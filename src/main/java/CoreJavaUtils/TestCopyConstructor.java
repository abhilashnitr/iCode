package CoreJavaUtils;
class PointOne
{
    public Integer x;
    public Integer y;

    public  PointOne(Integer x, Integer y){
        this.x=x;
        this.y=y;
    }
    public PointOne(PointOne point){
        this.x = point.x;
        this.y = point.y;
    }

    @Override
    public String toString() {
        return "PointOne{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class PointTwo extends PointOne
{
    private Integer z;
    public  PointTwo(Integer x, Integer y, Integer z){
        super(x,y);
        this.z=z;
    }
    public PointTwo(PointTwo point){
        super(point); //Call Super class constructor here
        this.z = point.z;
    }

    @Override
    public String toString() {
        return "PointTwo{" +
                "z=" + z +
                "super x"+super.toString() +
                '}';
    }
}

public class TestCopyConstructor {

    public static void main(String[] args)
    {
        PointOne one = new PointOne(1,2);
        PointTwo two = new PointTwo(1,2,3);

        PointOne clone1 = new PointOne(one);
        PointOne clone2 = new PointTwo(two);
        one.x=1000;
        one.y=1000;
        //Let check for class types
        System.out.println(clone1.getClass());
        System.out.println(clone2.getClass());
        System.out.println(one);
        System.out.println(two);
        System.out.println(clone1);
        System.out.println(clone2);

    }
}
