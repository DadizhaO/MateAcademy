package HM05;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

public class FruitMarket {
    List<Fruits> listOfFruits = new ArrayList<>();


    public void addFruits(Fruits fruits) {

        listOfFruits.add(fruits);
    }

    public List<Fruits> getFreshFruits(LocalDate date) {
        List<Fruits> listOfFresh = new ArrayList<>();
        for (Fruits fruit : listOfFruits) {
            if (fruit.shelfLife(date)) {
                listOfFresh.add(fruit);
            }
        }
        listOfFresh.forEach(System.out::println);
        return listOfFresh;
    }

    public List<Fruits> toTakeFruits(KindsOfFruits fruit) {
        List<Fruits> result = listOfFruits.stream().filter(a -> a.getKinds().equals(fruit)).collect(Collectors.toList());
        result.forEach(System.out::println);
        return result;
    }

    public List<Fruits> getFruitsStorageTime(int days) {
        List<Fruits> result = listOfFruits.stream().filter(a -> a.getStorageTime() > days).collect(Collectors.toList());
        result.forEach(System.out::println);
        return result;
    }

    public List<Fruits> getFreshFruitsByKind(KindsOfFruits kind, LocalDate date) {
        List<Fruits> result = listOfFruits.stream().
                filter(a -> a.getKinds().equals(kind) && a.shelfLife(date)).collect(Collectors.toList());
        result.forEach(System.out::println);
        return result;
    }

    public List<Fruits> changePrice(KindsOfFruits kind, int percent) {
        List<Fruits> otherFruits = new ArrayList<>();
        for (Fruits fruit : listOfFruits) {
            if (fruit.getKinds().equals(kind) && fruit.shelfLife(LocalDate.now())) {
                fruit.setPrice(fruit.getPrice() * (percent / 100));
                otherFruits.add(fruit);
            }
        }
        otherFruits.forEach(System.out::println);
        return otherFruits;
    }

}
