package main.FAANG.Multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerSolutionUsingLock {

    public static void main(String[] args) {
        ProducerConsumerImpl sharedObject = new ProducerConsumerImpl();

        Thread t1=new Thread(()->{
            try {
                sharedObject.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2=new Thread(()->{
            try {
                sharedObject.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.setName("Producer Thread");
        t2.setName("Consumer Thread");

        t1.start();
        t2.start();
        System.out.println("Hi");

    }




}

class ProducerConsumerImpl { // producer consumer problem data
    private static final int CAPACITY = 10;
    private final Queue<Integer> queue = new LinkedList<>();
    private final Random theRandom = new Random();
    // lock and condition variables
    private final Lock aLock = new ReentrantLock();
    private final Condition bufferNotFull = aLock.newCondition();
    private final Condition bufferNotEmpty = aLock.newCondition();

    public void put() throws InterruptedException {
        aLock.lock();
        while (true) {
            try {
                while (queue.size() == CAPACITY) {
                    System.out.println(Thread.currentThread().getName() + " : Buffer is full, waiting");
                    bufferNotEmpty.await();
                }
                int number = theRandom.nextInt();
                boolean isAdded = queue.offer(number);
                if (isAdded) {
                    System.out.printf("%s added %d into queue %n", Thread.currentThread().getName(), number); // signal consumer thread that, buffer has element now

                    System.out.println(Thread.currentThread().getName() + " : Signalling that buffer is no more empty now");
                    bufferNotFull.signalAll();
                }
            } finally {
                aLock.unlock();
            }
        }
    }

    public void get() throws InterruptedException {
        while (true) {
            aLock.lock();
            try {
                while (queue.size() == 0) {
                    System.out.println(Thread.currentThread().getName() + " : Buffer is empty, waiting");
                    bufferNotFull.await();
                }
                Integer value = queue.poll();
                if (value != null) {
                    System.out.printf("%s consumed %d from queue %n", Thread.currentThread().getName(), value); // signal producer thread that, buffer may be empty now
                    System.out.println(Thread.currentThread().getName() + " : Signalling that buffer may be empty now");
                    bufferNotEmpty.signalAll();
                }
            } finally {
                aLock.unlock();
            }
        }
    }
}
