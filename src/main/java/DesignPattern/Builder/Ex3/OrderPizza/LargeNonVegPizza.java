package DesignPattern.Builder.Ex3.OrderPizza;

public class LargeNonVegPizza extends NonVegPizza{

    @Override
    public float price() {
        return 220.0f;
    }

    @Override
    public String name() {
        return "Non-Veg Pizza";
    }

    @Override
    public String size() {
        return "Large Size";
    }

}// End of the LargeNonVegPizza class