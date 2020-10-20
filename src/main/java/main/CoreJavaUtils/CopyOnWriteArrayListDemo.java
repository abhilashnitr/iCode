package main.CoreJavaUtils;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

  public static void main (String[] args) {
    CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>(new Integer[] {1,2,3});
    System.out.println(list);
    Iterator<Integer> itr1 = list.iterator();
    list.add(4);
    System.out.println(list);
    Iterator<Integer> itr2 = list.iterator();

    System.out.println("====Verify Iterator 1 content====");
    while (itr1.hasNext()){
      int a=itr1.next();
      System.out.print(a+" ");
    }
    System.out.println();
    System.out.println("====Verify Iterator 2 content====");
    while (itr2.hasNext()){
      System.out.print(itr2.next()+" ");
    }
  }

}
