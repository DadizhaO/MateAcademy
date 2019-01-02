package HM04;

public class Securities extends BasicAbstClass implements BasicInterface {


    public Securities(int quantity) {
        super(quantity);
    }

    @Override
    public void toCheck() {
        System.out.println("Balance of sucurities " + getQuantity());
    }


}
