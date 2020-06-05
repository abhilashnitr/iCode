package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Test1{

  Test1(){
    System.out.println("out");
  }
  public static void main (String[] args) {

    Boolean b1=new Boolean("TRUE");
    Boolean b2=new Boolean("true");
    System.out.println(b1 .equals(b2));
  }

  interface Test{
    char getCHar();
    int getInt();

  }
  abstract class Test3 implements Test{
    public char getCHar(){
      return 0;
    }


  }


}