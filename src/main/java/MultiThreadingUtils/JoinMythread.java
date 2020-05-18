package MultiThreadingUtils;

public class JoinMythread extends Thread {
  static Thread mt;
  public static void main(String[] args) throws InterruptedException {
    mt = Thread.currentThread();
    JoinMythread t = new JoinMythread();
    t.start();
    for (int i = 0; i < 3; i++) {
      System.out.println("main thread");
      Thread.sleep(2000);
    }
  }
  public void run(){
    try {
      mt.join();
    }catch (InterruptedException e){
      e.printStackTrace();
    }
    for (int i = 0; i < 3; i++) {
      System.out.println("child thread");
    }
  }



}
