package HM20.decoratorPattern;

public class SimpleCoffee implements Coffee {
    private int price = 15;

    @Override
    public int getCost() {
        return price;

    }

    @Override
    public String getDescription() {
        return "coffee";
    }
}
