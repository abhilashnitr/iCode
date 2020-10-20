package main.CoreJavaUtils;

public class TestClass {

  public static void main (String[] args) {
    A widget=new A();
    B widget1=new B();
    draw(widget);
    draw(widget1);
  }

  public static void draw(Widget widget){
    widget.draw();
  }

}


interface Widget{

  void draw();

}
class A implements Widget{

  @Override
  public void draw () {
    System.out.println("A is a widget");
  }
}

class B implements Widget{

  @Override
  public void draw () {
    System.out.println("B is a widget");
  }
}

