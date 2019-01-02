package HM04;

public class Main {

    public static void main(String[] args) {
        Currency currency = new Currency(120);
        Gold gold = new Gold(150);
        Securities securities = new Securities(110);

        Bank<BasicInterface> bank = new Bank<>("str 1", "Bank1", currency);
        Bank<Gold> bank1 = new Bank<>("str 2", "Bank2", gold);
        Bank<Securities> bank2 = new Bank<>("str 4", "Bank5", securities);

        bank.getAsset().toCheck();
        bank1.getAsset().toCheck();
        bank2.getAsset().toCheck();

        bank.toRefillAssets(currency, 12);
        bank.toRefillAssets(gold, 10);

        bank.toTakeAssets(securities, 3);

    }
}
