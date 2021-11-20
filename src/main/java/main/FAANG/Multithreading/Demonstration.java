package main.FAANG.Multithreading;

import java.util.Random;

class Demonstration {

//    public static void main(String args[]) throws InterruptedException {
//        RaceCondition.runTest();
//    }

    public static void main(String args[]) {
        Deadlock deadlock = new Deadlock();
        try {
            deadlock.runTest();
        } catch (InterruptedException ie) {
        }
    }

}
class RaceCondition {

    int randInt;
    Random random = new Random(System.currentTimeMillis());

    void printer() {

        int i = 1000000;
        while (i != 0) {
            if (randInt % 5 == 0) {
                if (randInt % 5 != 0)
                    System.out.println(randInt);
            }
            i--;
        }
    }

    void modifier() {

        int i = 1000000;
        while (i != 0) {
            randInt = random.nextInt(1000);
            i--;
        }
    }

    public static void runTest() throws InterruptedException {


        final RaceCondition rc = new RaceCondition();
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                rc.printer();
            }
        });
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                rc.modifier();
            }
        });


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }


}

class Deadlock {

    private int counter = 0;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    Runnable incrementer = () -> {
        try {
            for (int i = 0; i < 100; i++) {
                incrementCounter();
                System.out.println("Incrementing " + i);
            }
        } catch (InterruptedException ie) {
        }
    };

    Runnable decrementer = () -> {
        try {
            for (int i = 0; i < 100; i++) {
                decrementCounter();
                System.out.println("Decrementing " + i);
            }
        } catch (InterruptedException ie) {
        }

    };

    public void runTest() throws InterruptedException {

        Thread thread1 = new Thread(incrementer);
        Thread thread2 = new Thread(decrementer);

        thread1.start();
        // sleep to make sure thread 1 gets a chance to acquire lock1
        Thread.sleep(100);
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Done : " + counter);
    }

    void incrementCounter() throws InterruptedException {
        synchronized (lock1) {
            System.out.println("Acquired lock1"+Thread.currentThread().getName());
            Thread.sleep(100);

            synchronized (lock2) {
                System.out.println("Acquired lock12"+Thread.currentThread().getName());

                counter++;
            }
        }
    }

    void decrementCounter() throws InterruptedException {
        synchronized (lock2) {
            System.out.println("Acquired lock2"+Thread.currentThread().getName());

            Thread.sleep(100);
            synchronized (lock1) {
                System.out.println("Acquired lock21"+Thread.currentThread().getName());

                counter--;
            }
        }
    }
}


