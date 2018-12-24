package HM02;

public class Pizza2 {
    private double weight;
    private String meet;
    private String cheese;
    private String mushrooms;
    private String topping;

    public static class Builder2{
        private Pizza2 pizza2;

        public Builder2(){
             pizza2 = new Pizza2();
        }

        public Builder2 withWeight(double weight){
            pizza2.weight = weight;
            return this;
        }

        public Builder2 withMeet(String meet) {
            pizza2.meet = meet;
            return this;
        }

        public Builder2 withCheese(String cheese) {
            pizza2.cheese = cheese;
            return this;
        }

        public Builder2 withMushrooms(String mushrooms) {
            pizza2.mushrooms = mushrooms;
            return this;
        }

        public Builder2 withTopping(String topping) {
            pizza2.topping = topping;
            return this;
        }

        public Pizza2 build(){
            return pizza2;
        }

    }

    @Override
    public String toString() {
        return "Pizza2{" +
                "weight=" + weight +
                ", meet='" + meet + '\'' +
                ", cheese='" + cheese + '\'' +
                ", mushrooms='" + mushrooms + '\'' +
                ", topping='" + topping + '\'' +
                '}';
    }
}
