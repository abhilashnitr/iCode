package CoreJavaUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class ImmutableEmployee2{
    private final int id;
    private final String name;
    private final Course1 course1;
    private final List<Integer> list;
    private final String[] str;

    ImmutableEmployee2(int id, String name, Course1 course1, String[] str, List<Integer> list){
        this.id = id;
        this.name = name;
        this.course1 = course1;
        this.str=str;
        this.list=list;
    }

    public List<Integer> getList() {
        return Collections.unmodifiableList(new ArrayList<>(list));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String[] getStr() {
        return str.clone();
    }

    public Course1 getCourse1() {
        Course1 course2=new Course1(course1.subject1,course1.subject2,course1.subject3);
        return course2;
      //    return course1;
    }


}

public class ImmutableClassExample2 {

    public static void main(String[] args) {
        Course1 science = new Course1("Physics", "Chemistry", "Biology");
        String[] str=new String[]{"Hi","Hello"};
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        ImmutableEmployee2 immutableEmployee2=new ImmutableEmployee2(1,"Abhilash",science,str,list);
        String[] str1=immutableEmployee2.getStr();
        str1[0]="ChangeHi";
        Course1 science1=immutableEmployee2.getCourse1();
        science1.subject1="Math";
        List<Integer> list1=immutableEmployee2.getList();
        list1.add(4);
        System.out.println(immutableEmployee2.getCourse1().subject1);
        System.out.println(immutableEmployee2.getStr()[0]);
        System.out.println(immutableEmployee2.getList().size());
    }

}
