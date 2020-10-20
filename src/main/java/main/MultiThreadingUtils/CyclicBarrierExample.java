package main.MultiThreadingUtils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CyclicBarrierExample {

  //Runnable task for each thread
  private static class Task implements Runnable {

    private CyclicBarrier barrier;

    public Task(CyclicBarrier barrier) {
      this.barrier = barrier;
    }

    @Override
    public void run() {
      try {
        System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
        barrier.await();
        System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
      } catch (InterruptedException ex) {
        Logger.getLogger(CyclicBarrierExample.class.getName()).log(Level.SEVERE, null, ex);
      } catch (BrokenBarrierException ex) {
        Logger.getLogger(CyclicBarrierExample.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  public static void main(String args[]) {

    //creating CyclicBarrier with 3 parties i.e. 3 Threads needs to call await()
    final CyclicBarrier cb = new CyclicBarrier(3, () -> {
      //This task will be executed once all thread reaches barrier
      System.out.println("All parties are arrived at barrier, lets play");
    });

    //starting each of thread
    Thread t1 = new Thread(new Task(cb), "Thread 1");
    Thread t2 = new Thread(new Task(cb), "Thread 2");
    Thread t3 = new Thread(new Task(cb), "Thread 3");

    t1.start();
    t2.start();
    t3.start();

  }


}
/*
1) To implement multi player game which can not begin until all player has joined.
    2) Perform lengthy calculation by breaking it into smaller individual tasks, In general, to implement Map reduce technique.


    Read more: https://javarevisited.blogspot.com/2012/07/cyclicbarrier-example-java-5-concurrency-tutorial.html#ixzz6LNSwoVQn
*/