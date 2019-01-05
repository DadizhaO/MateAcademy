package HM04;

public class Gold extends BasicAbstClass implements BasicInterface {


    public Gold(int quantity) {
        super(quantity);
    }

    @Override
    public void toCheck() {
        System.out.println("Balance of gold " + getQuantity());
    }


}
