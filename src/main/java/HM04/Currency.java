package HM04;

public class Currency extends BasicAbstClass implements BasicInterface {


    public Currency(int quantity) {
        super(quantity);
    }

    @Override
    public void toCheck() {
        System.out.println("Balance of currency " + getQuantity());
    }


}
