package HM20.decoratorPattern;

public class MilkCoffee implements Coffee {

    Coffee coffee;

    public MilkCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getCost() {
        return coffee.getCost() + 6;

    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " milk";
    }
}
