package CoreJavaUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CheckConcurrentModification {

  public static void main (String[] args) {
    ArrayList<Integer> list=new ArrayList<>(Arrays.asList(2,3,4,5,6,7,8,9,10));

//    for (int i=0;i<list.size();i++){
//      list.remove(i);
//      System.out.println(list.get(i));
//    }

    Iterator<Integer> itr1 = list.iterator();
    while (itr1.hasNext()){
      int a=itr1.next();
      if (a == 2) {
       //list.add(11);     leads to ConcurrentModificationException
       //list.remove();             ConcurrentModificationException
       // list.add(2,11);           ConcurrentModificationException
      }
      System.out.print(a+" ");
    }

    Iterator<Integer> itr = list.iterator();
    while (itr.hasNext()) {

      if (itr.next() == 2) {
        // will not throw Exception
        itr.remove();
      }
    }
    System.out.println(list);



  }

}
