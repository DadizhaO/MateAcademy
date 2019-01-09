package HM05;

enum KindsOfFruits {

    APPLE("Apple"),
    LEMON("Lomon"),
    BANANAS("Banana"),
    PEAR("Paer");

    private String type;

    KindsOfFruits(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}