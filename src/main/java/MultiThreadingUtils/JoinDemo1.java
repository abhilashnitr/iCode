package MultiThreadingUtils;

public class JoinDemo1 extends Thread{


  public static void main(String[] args) throws InterruptedException {
    JoinDemo1 t = new JoinDemo1();
    t.start();
    t.join();
    for (int i = 0; i < 3; i++) {
      System.out.println("main thread"+Thread.currentThread().getName());
      Thread.sleep(2000);
    }
  }
  public void run(){
    try {
      for (int i = 0; i < 3; i++) {
        System.out.println("Child thread"+Thread.currentThread().getName());
        Thread.sleep(2000);
      }
    }catch (InterruptedException e){
      e.printStackTrace();
    }

  }

}
