package main.CoreJavaUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class collectionImmutableDemo {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>(list1);
        list2.add(70);
        List<Integer> UnmodifiableList= Collections.unmodifiableList(new ArrayList<>(list1));
       // List immutableList= List.of(new ArrayList<>(list1));
        try {
            list1.add(6);
         //   immutableList.add(5);
            UnmodifiableList.add(5);


        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }finally {
            //System.out.println(list1.add(5));
            list1.forEach(val-> System.out.print(val+" "));
            System.out.println();
            UnmodifiableList.forEach(val-> System.out.print(val+" "));
            System.out.println();
           // immutableList.forEach(val-> System.out.print(val+" "));
            System.out.println();
        }
        System.out.println(list2.size());
        list2.forEach(val-> System.out.print(val+" "));

    }
}
