package main.MultiThreadingUtils;

import java.nio.channels.InterruptedByTimeoutException;
import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ExecutorServiceRunnable {
  public static void main(String[] args)
  {
    //Demo task
    Runnable runnableTask = () -> {
      try {
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("Current time :: " + LocalDateTime.now());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    };

    Callable<Integer> callableTask = () -> {
      System.out.println("Hello");
      return 2;
    };

    //Executor service instance
    ExecutorService executor = Executors.newFixedThreadPool(10);

    //1. execute task using execute() method
    executor.execute(runnableTask);

    //2. execute task using submit() method
    Future<String> result = executor.submit(runnableTask, "DONE");
    Future<Integer> result2 = executor.submit(callableTask);
    if (result2.isDone()){
      try {
        System.out.println("Hello"+result2.get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
    while(result2.isDone() == false)
    {
      try
      {
        System.out.println("The method return value : " + result2.get());
        break;
      }
      catch (InterruptedException | ExecutionException e)
      {
        e.printStackTrace();
      }

      //Sleep for 1 second
      try {
        Thread.sleep(1000L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    //Shut down the executor service
    executor.shutdownNow();
  }
}
