package main.DesignPattern.Adapter;

public class Crow implements Bird {

  @Override
  public void fly () {

  }

  @Override
  public void makeSound () {
    System.out.println("I am a Crow");
  }
}
