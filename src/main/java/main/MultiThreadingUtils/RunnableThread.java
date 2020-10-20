package main.MultiThreadingUtils;

public class RunnableThread {

  public static void main(String[] args) {
    Thread thread=new Thread(()->{
      System.out.println(Thread.currentThread().getName()+" calling a thread ");
    },"Print");
  thread.start();
  }

}
