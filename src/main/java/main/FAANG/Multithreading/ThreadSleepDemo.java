package main.FAANG.Multithreading;

public class ThreadSleepDemo {

    public static void main(String[] args) {


        Runnable runnabletask=new Runnable() {
            @Override
            public void run() {
                    int i=0;
                    try {
                        while (i<10) {
                            System.out.println(i+" "+Thread.currentThread().getName());
                                i++;
                            Thread.sleep(500);
                        }
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName()+" got interrupted");
                    }
            }
        };

        Thread t1=new Thread(runnabletask);
        t1.setName("CHILD");
        t1.start();
        t1.interrupt();

        System.out.println("Main THread");
    }
}
