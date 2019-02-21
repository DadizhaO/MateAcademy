package HM20.decoratorPattern;

public class CreamCoffee implements Coffee {
    Coffee coffee;

    public CreamCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getCost() {
        return coffee.getCost() + 4;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " cream";
    }
}
