package main.FAANG.DesignPatterns.structural.decorator.ex1;

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
