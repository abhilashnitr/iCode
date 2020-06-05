package main.CoreJavaUtils.FunctionalInterface;

import java.util.function.Consumer;

public class ConsumerDemo {

  static class Point {
    Double x, y;

    public Point(Double x, Double y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String... args) {
    Point point = new Point(1.0, 2.0);

    Consumer<Point> pointPrinter1 = (p) -> System.out.printf("x = %f, y = %f\n", p.x, p.y);
    Consumer<Point> pointPrinter2 = (p) -> System.out.printf("(%f, %f)\n", p.x, p.y);

    pointPrinter1.accept(point);
    pointPrinter2.accept(point);
  }
}
