package main.FAANG.DesignPatterns.structural.decorator.ex1;

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
