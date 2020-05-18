package DesignPattern.Builder.Ex3.OrderPizza;

public class LargeCoke extends Coke {
    @Override
    public String name() {
        return "750 ml Coke";
    }

    @Override
    public String size() {

        return "Large Size";
    }

    @Override
    public float price() {

        return  50.0f;
    }
}// End of the LargeCoke class