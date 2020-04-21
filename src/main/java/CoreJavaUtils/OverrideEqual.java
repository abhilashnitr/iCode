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

//    //Overriding equals
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Person that = (Person) obj;
        if (this.age != that.age) return false;
        if (!this.fname.equals(that.fname)) return false;
        if (!this.lname.equals(that.lname)) return false;
        return true;
    }

    @Override
    public int hashCode(){
        final int prime=31;
        int result=1;
        result=prime*result+((fname==null)?0:fname.hashCode())
                            +((lname==null)?0:lname.hashCode());

        return result;
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
