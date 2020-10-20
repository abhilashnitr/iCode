import java.util.LinkedList;
import java.util.Queue;


/*
 10000r per sec
 1 core System
 Async
 main func call proc fun then sleep for 1 sec

*/
class   test{
   void processing () {
    System.out.println("Processing 1");
  }
}
class Test1 extends test{

  public static void main (String[] args) {
    test t=new Test1();
   // Test1 t1= (Test1) new test();
    t.processing();
    //t1.processing();
  }
   public  void processing () {
    System.out.println("processing 2");
  }
  static class B{
      class C{
      }
  }
  static class D{
    static class E{}
  }
}

