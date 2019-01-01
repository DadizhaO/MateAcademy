package HM04;

public class Currency implements BasicInterface {

    private int quantity;

     Currency(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public void toCheck() {
        System.out.println("Balance of currency " + getQuantity());
    }


}
