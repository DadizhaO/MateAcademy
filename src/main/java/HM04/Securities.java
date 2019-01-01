package HM04;

public class Securities implements BasicInterface {


    private int quantity;

    Securities(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void toCheck() {
        System.out.println("Balance of sucurities " + getQuantity());
    }

    public int getQuantity() {
        return quantity;
    }

}
