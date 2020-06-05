package main.CoreJavaUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class TesthashMap {

  public static void main(String[] args) {
    Person p1=new Person(1,"Hello");
    Person p2=new Person(2,"hI");
    Person p3=new Person(3,"Hello");
    System.out.println(p1.equals(p2)+" "+p1.equals(p1)+" "+p1.equals(p3));

    HashMap<Person,String> map=new HashMap();

    map.put(p1,"A");
    map.put(p2,"B");
   // map.put(p3,"C");

    System.out.println(map.size()+" "+map.get(p1)+" "+map.get(p2)+" "+map.get(p3));

    for(Entry<Person, String> entry:map.entrySet()){

      System.out.println(entry.getValue()+" "+entry.getKey());

    }



//    Iterator<Entry<Person, String>> itr = map.entrySet().iterator();
//    while (itr.hasNext()){
//      System.out.println(itr.next()+" ");
//      //map.put(p3,"c");        ConcurrentModificationException   adding new values
//      //map.remove(p2);         ConcurrentModificationException
//
//    }
  }

  static class Person {

    int id;
    String name;

    @Override
    public String toString () {
      return "Person{" +
          "id=" + id +
          ", name='" + name + '\'' +
          '}';
    }

//    @Override
//    public int hashCode () {
//      return 1;
//    }

    @Override
    public boolean equals (Object o) {
      return true;
    }

    public Person (int id,String name) {
      this.id = id;
      this.name = name;
    }
  }


}
