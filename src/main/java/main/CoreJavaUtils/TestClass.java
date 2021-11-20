package main.CoreJavaUtils;

public class TestClass {

  public static void main (String[] args) {
    A widget=new A();
    B widget1=new B();
    draw(widget);
    draw(widget1);

    child child=new child();
    abc child1=new child();
    child.draw();
    child1.draw();
  }

  public static void draw(Widget widget){
    widget.draw();
  }

}

abstract class abc{

  static void draw(){
    System.out.println("Abstract class");
  }
}
class child extends abc{

  static void draw(){
    System.out.println("Child class");
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

