package DesignPattern.Builder.Ex3.OrderPizza;

public abstract class NonVegPizza extends Pizza{
    @Override
    public abstract float price();
    @Override
    public abstract String name();
    @Override
    public abstract String size();
}// End of the abstract class NonVegPizza.