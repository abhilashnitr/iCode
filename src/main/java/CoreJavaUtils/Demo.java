package CoreJavaUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {

   Employee emp2=new Employee(2,"Jaswinder");
   String s1="ABC";
  public static void main(String[] args) {
    Employee emp=new Employee(1,"Abhilash");
    Demo dm=new Demo();
    dm.changeEmp(emp);
    System.out.println(emp.getId());
    dm.changeEmp(dm.emp2);
    dm.changeString(dm.s1);
    System.out.println(dm.s1);
    String s2="Abhilash";
    dm.changeString(s2);
    System.out.println(s2);
    System.out.println(dm.emp2.getId());

    List<String> list=new ArrayList<>(Arrays.asList("A","B","C"));
    System.out.println(list);
    dm.updateList(list);
    System.out.println(list);
  }

  private  void updateList(List<String> list) {
    list.add("D");
    System.out.println(list);
    list=new ArrayList<>(Arrays.asList("X", "Y", "Z"));
    list.add("1");
    System.out.println(list);
  }

  private void changeString(String s1) {
    s1="XYZ";
  }

  private void changeEmp(Employee emp) {
    emp.setId(5);
  }

}

//read this
//https://mkyong.com/java/is-java-pass-by-value-or-pass-by-reference/
//https://www.geeksforgeeks.org/g-fact-31-java-is-strictly-pass-by-value/