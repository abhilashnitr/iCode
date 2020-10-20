package main.CoreJavaUtils.FunctionalInterface;

import java.util.function.Supplier;

public class SupplierDemo {
  static class Car {
    String brand;
    int engineCC;
    int wheelCount;
    int price;

    public Car(String brand, int engineCC, int wheelCount, int price) {
      this.brand = brand;
      this.engineCC = engineCC;
      this.wheelCount = wheelCount;
      this.price = price;
    }

    @Override
    public String toString() {
      return "Car{" +
          "brand='" + brand + '\'' +
          ", engineCC=" + engineCC +
          ", wheelCount=" + wheelCount +
          ", price=" + price +
          '}';
    }
  }
  public static void main(String... args) {
    Supplier<Car> fordCarProvider = () -> new Car("Ford", 1500, 4, 43000);
    Supplier<Car> bmwCarProvider = () -> new Car("BMW", 1500, 4, 83000);

    System.out.println(fordCarProvider.get());
    System.out.println(bmwCarProvider.get());
  }

}
