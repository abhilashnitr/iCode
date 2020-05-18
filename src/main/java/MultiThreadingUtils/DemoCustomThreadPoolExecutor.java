package MultiThreadingUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DemoCustomThreadPoolExecutor {

  public static void main(String[] args)
  {
    Integer threadCounter = 0;
    BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);

    CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(10,
        20, 5000, TimeUnit.MILLISECONDS, blockingQueue);

    executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
      @Override
      public void rejectedExecution(Runnable r,
          ThreadPoolExecutor executor) {
        System.out.println("DemoTask Rejected : "
            + ((DemoTask) r).getName());
        System.out.println("Waiting for a second !!");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("Lets add another time : "
            + ((DemoTask) r).getName());
        executor.execute(r);
      }
    });
    // Let start all core threads initially
    executor.prestartAllCoreThreads();
    while (true) {
      threadCounter++;
      // Adding threads one by one
      System.out.println("Adding DemoTask : " + threadCounter);
      executor.execute(new DemoTask(threadCounter.toString()));

      if (threadCounter == 5)
        break;
    }
  }

}
