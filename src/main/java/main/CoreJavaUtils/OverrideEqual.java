package main.CoreJavaUtils;
class Person
{
    private String fname;
    private String lname;
    private int age;

    public Person(String fname, String lname, int age)
    {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }


    @Override
    public int hashCode(){

       return 1;
    }
}

public class OverrideEqual {
    public static void main(String str[])
    {
        Person p1 = new Person("Ravi", "kumar", 7);
        Person p2 = new Person("Ravi", "Kumar", 7);
        int i=p1.hashCode();
        int j=p2.hashCode();
        if(i==j){
            System.out.println(i==j);
        }
        System.out.println(i+" "+j+" ");
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p1));
        System.out.println(p2.equals(p1));
    }
}
