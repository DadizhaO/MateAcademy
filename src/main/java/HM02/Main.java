package HM02;

public class Main {
    public static void main(String[] args) {
         double weight = 300;
         String meet = "Chicken";
         String cheese = "Parmesan";
         String mushrooms = "Mushroom";
         String topping = "Pineapple";


         Pizza pizza = Pizza.builder().withMeet(meet).buildPizza();
        System.out.println(pizza.toString());

        Pizza2 pizza2 = new Pizza2.Builder2().withCheese(cheese).withTopping(topping).build();
        System.out.println(pizza2);

        Pizza3 pizza3 = new Pizza3.Pizza3Builder().setCheese(cheese).setMeet(meet).createPizza3();
        System.out.println(pizza3);
    }


}
