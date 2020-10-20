package main.DesignPattern.Decorator;
// 1. "lowest common denominator"
interface Widget {
  void draw();
}

// 3. "Core" class with "is a" relationship
class TextField implements Widget {
  private int width, height;

  public TextField(int width, int height) {
    this.width = width;
    this.height = height;
  }
  public void draw() {
    System.out.println("TextField: " + width + ", " + height);
  }
}

// 2. Second level base class with "isa" relationship
abstract class Decorator implements Widget {
  // 4. "has a" relationship
  private Widget widget;

  public Decorator(Widget widget) {
    this.widget = widget;
  }

  // 5. Delegation
  public void draw() {
    widget.draw();
  }
}

// 6. Optional embellishment
class BorderDecorator extends Decorator {
  public BorderDecorator(Widget widget) {
    super(widget);
  }
  public void draw() {
    // 7. Delegate to base class and add extra stuff
    super.draw();
    System.out.println("  BorderDecorator");
  }
}

// 6. Optional embellishment
class ScrollDecorator extends Decorator {
  public ScrollDecorator(Widget widget) {
    super(widget);
  }
  public void draw() {
    super.draw(); // 7. Delegate to base class and add extra stuff
    System.out.println("  ScrollDecorator");
  }
}

public class DecoratorDemo {
  public static void main(String[] args) {
    // 8. Client has the responsibility to compose desired configurations

    Widget widget1=new ScrollDecorator(new TextField(80,24));;
    widget1.draw();
    System.out.println("-----------try------------");
    Widget widget = new BorderDecorator(new BorderDecorator(new ScrollDecorator(new TextField(80, 24))));
    widget.draw();
  }
}
