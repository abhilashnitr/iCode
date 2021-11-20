package main.FAANG.Multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerComsumerUsingWaitNotify {

    public static void main(String[] args) throws InterruptedException {

        ProducerComsumerImpl pc=new ProducerComsumerImpl(4);
        Thread t1=new Thread(()->{
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2=new Thread(()->{
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.setName("Producer");
        t2.setName("Consumer");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("DOne");
    }
}
class ProducerComsumerImpl{

    int cap;
    int counter =0;
    Queue<Integer> queue=new LinkedList<>();

    ProducerComsumerImpl(int cap){
        this.cap=cap;
    }

    public void produce() throws InterruptedException {

        while(true){
            synchronized (this){
                if(queue.size()==cap)
                    wait();
                System.out.println(Thread.currentThread().getName()+" adding id " + counter + "to Queue");

                queue.offer(counter);
                counter++;
                notify();
                Thread.sleep(100);
            }
        }
    }

    public void consume() throws InterruptedException {

        while(true){
            synchronized (this){
                if(queue.size()==0)
                    wait();
                System.out.println(Thread.currentThread().getName()+" consumer id " + queue.poll() + "from Queue");

                notify();
                Thread.sleep(100);
            }
        }
    }


}
