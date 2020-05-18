package DesignPattern.Builder.Ex1.HousePlan;

public interface HouseBuilder {
    public void buildBasement();

    public void buildStructure();

    public void bulidRoof();

    public void buildInterior();

    public House getHouse();
}
