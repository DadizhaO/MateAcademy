package HM20.decoratorPattern;

public class Main {
    public static void main(String[] args) {
        Coffee someCoffee = new SimpleCoffee();
        System.out.println(someCoffee.getDescription());
        System.out.println(someCoffee.getCost());

        someCoffee = new MilkCoffee(someCoffee);
        System.out.println(someCoffee.getDescription());
        System.out.println(someCoffee.getCost());

        Coffee someCoffee3 = new SimpleCoffee();
        someCoffee3 = new CreamCoffee(someCoffee3);
        System.out.println(someCoffee3.getDescription());
        System.out.println(someCoffee3.getCost());

    }


}
