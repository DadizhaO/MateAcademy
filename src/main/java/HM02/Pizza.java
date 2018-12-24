package HM02;

public class Pizza {

    private double weight;
    private String meet;
    private String cheese;
    private String mushrooms;
    private String topping;


    public Pizza(Builder builder) {
        this.weight = builder.weight;
        this.meet = builder.meet;
        this.cheese = builder.cheese;
        this.mushrooms = builder.mushrooms;
        this.topping = builder.topping;

    }

   public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private double weight;
        private String meet;
        private String cheese;
        private String mushrooms;
        private String topping;

        private Builder() {
        }

        public Builder withWeight(double weight){
            this.weight = weight;
            return this;
        }

        public Builder withMeet(String meet) {
            this.meet = meet;
            return this;
        }

        public Builder withCheese(String cheese) {
            this.cheese = cheese;
            return this;
        }

        public Builder withMushrooms(String mushrooms) {
            this.mushrooms = mushrooms;
            return this;
        }

        public Builder withTopping(String topping) {
            this.topping = topping;
            return this;
        }

        public Pizza buildPizza(){
            return new Pizza(this);
        }

    }

    @Override
    public String toString() {
        return "Pizza{" +
                "weight=" + weight +
                ", meet='" + meet + '\'' +
                ", cheese='" + cheese + '\'' +
                ", mushrooms='" + mushrooms + '\'' +
                ", topping='" + topping + '\'' +
                '}';
    }
}
