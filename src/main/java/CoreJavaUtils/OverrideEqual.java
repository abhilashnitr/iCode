package CoreJavaUtils;
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
       /* final int prime=31;
        int result=1;
        result=prime*result+((fname==null)?0:fname.hashCode())
                            +((lname==null)?0:lname.hashCode());

        return result;*/
       return 1;
    }
}

public class OverrideEqual {
    public static void main(String str[])
    {
        Person p1 = new Person("Anushka", "Krishan", 7);
        Person p2 = new Person("Anushka", "Krishan", 7);
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
