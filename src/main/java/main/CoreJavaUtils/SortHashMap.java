package main.CoreJavaUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class SortHashMap {

  public static void main(String[] args) {

    String s="abc 2 3 4";
    String[] str=s.split(" ");
    System.out.println(str.length);
    HashMap<String,Integer> map=new HashMap<>();
    map.put("A",12);
    map.put("B",13);
    map.put("C",5);
    map.put("D",5);
    map.put("E",12);
    map.put("F",3);
    map.put("G",2);
    map.put("H",1);

    Set<Entry<String,Integer>> entries=map.entrySet();
    List<Entry<String,Integer>> listEntries=new ArrayList<>(entries);

    Comparator<Entry<String,Integer>> sortMap=new Comparator<Entry<String, Integer>>() {
      @Override
      public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        String s1=o1.getKey();
        String s2=o2.getKey();
        Integer i1=o1.getValue();
        Integer i2=o2.getValue();
        if(i1==i2)
          return s1.compareTo(s2);
        return i1-i2;
      }
    };
    Collections.sort(listEntries,sortMap.reversed());
    for(Entry<String,Integer> entry:listEntries){
      System.out.println("Key :"+entry.getKey()+" value :"+entry.getValue());
    }

  }

}
