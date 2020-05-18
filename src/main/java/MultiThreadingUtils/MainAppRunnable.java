package MultiThreadingUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Concurrent Programming in action
public class MainAppRunnable implements Runnable {

    private final int loopLimit;

    // Limit till which the counter will run
    private MainAppRunnable(int loopLimit)
    {
        this.loopLimit = loopLimit;
    }

    private void startThreads()
    {

        // Made the task queue
        ExecutorService taskList
                = Executors.newFixedThreadPool(2);

        // Added these to the task queue
        // and made available for execution
        taskList.execute(this);
        taskList.execute(this);
        taskList.execute(this);
        taskList.execute(this);
        taskList.execute(this);

        // Stopped new tasks from being
        // added to the task queue
        taskList.shutdown();
    }

    @Override
    public void run()
    {
        for (int i = 0; i < loopLimit; i++) {
            System.out.println(
                    Thread.currentThread().getName()
                            + " Counter: " + i);
        }

        // Called private method that is
        // part of the same application
        pause(Math.random());
    }

    // Methods that run uses can be private
    // in this approach
    private void pause(double seconds)
    {
        try {
            Thread
                    .sleep(Math.round(seconds * 1000.0));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Driver method
    public static void main(String[] args)
    {
        new MainAppRunnable(3).startThreads();
    }
}
