package HM04;

public class Main {

    public static void main(String[] args) {
        Currency currency = new Currency(120);
        Gold gold = new Gold(150);
        Securities securities = new Securities(110);

        Bank<BasicInterface> bank = new Bank<>();

        bank.toCheckAssets(currency);
        bank.toCheckAssets(gold);
        bank.toCheckAssets(securities);

        bank.toRefillAssets(currency, 12);
        bank.toRefillAssets(gold, 10);

        bank.toTakeAssets(securities, 3);

    }
}
