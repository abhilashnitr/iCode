package main.MultiThreadingUtils;

public class EvenOddThread {

  public static void main(String[] args) {
    evenOdd e=new evenOdd(10);

    Thread t1=new Thread(()->{
      e.printeven();
    });

    Thread t2=new Thread(()->{
      e.printOdd();
    });

    t1.setName("Even Thread");
    t2.setName("Odd Thread");
    t1.start();
    t2.start();
  }
}
class evenOdd{
  final int index;
  int count=1;
  Boolean odd=false;
  evenOdd(int index){
    this.index=index;
  }

  void printOdd(){
    while(count<index) {
      synchronized (this) {
        while (odd) {
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println(Thread.currentThread().getName() + " " + count);
        count++;
        odd = !odd;
        notify();
      }
    }
  }

  void printeven() {
    while (count < index) {
      synchronized (this) {
        while (!odd) {
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println(Thread.currentThread().getName() + " " + count);
        count++;
        odd = !odd;
        notify();
      }
    }
  }

}