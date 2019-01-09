package HM05;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Runner {


    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate dayOfSupply = LocalDate.of(2016, Month.APRIL, 1);

        FruitMarket market = new FruitMarket();

        market.addFruits(new Fruits(12, LocalDate.of(2019, Month.JANUARY, 2), 12, KindsOfFruits.APPLE));
        market.addFruits(new Fruits(12, LocalDate.of(2018, Month.APRIL, 2), 12, KindsOfFruits.PEAR));
        market.toTakeFruits(KindsOfFruits.APPLE);

        market.getFruitsStorageTime(2);
        market.getFreshFruits(LocalDate.of(2014, Month.APRIL, 3));
        market.getFreshFruitsByKind(KindsOfFruits.APPLE, LocalDate.of(2014, Month.APRIL, 15));
        market.changePrice(KindsOfFruits.APPLE, 50);

    }
}
