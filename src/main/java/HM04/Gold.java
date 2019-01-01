package HM04;

public class Gold implements BasicInterface {

    private int quantity;

    Gold(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void toCheck() {
        System.out.println("Balance of gold " + getQuantity());
    }

    public int getQuantity() {
        return quantity;
    }

}
