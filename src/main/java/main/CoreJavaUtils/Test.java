package main.CoreJavaUtils;

public class Test {
    {
        System.out.println("initializer");
    }
    static {
        System.out.println("static initializer ");
    }

  public static void main (String[] args) {
    Test t1=new Test();
    Test t2=new Test();
//    t.printObj(null);
//    TestThread testThread=new TestThread();
//    testThread.start();
  }

  public void printObj(Object obj){
    System.out.println("Inside Obj");
  }
  public void printObj(String str){
    System.out.println("Inside str");
  }


}

 class TestThread extends Thread{
      public void start (){
      System.out.println("Inside start");
    }
  public void run (){
    System.out.println("Inside run");
  }

}
