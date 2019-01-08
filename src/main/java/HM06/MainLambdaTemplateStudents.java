package HM06;


import java.time.LocalDate;

import java.util.*;

import java.util.stream.Stream;

import static HM06.FruitType.*;
import static HM06.Vitamins.*;


public class MainLambdaTemplateStudents {

    public static void main(String[] args) {

        List<Fruit> fruits = fillFruitsList();

        // fruits.forEach(System.out::println);

        System.out.println("filter");
        Stream<Fruit> result = fruits.stream().filter(a -> a.getFruitType().equals(PEAR));
        result.forEach(System.out::println);

        fruits.stream().filter((a) -> a.equals(APPLE)).forEach(System.out::println);

        System.out.println("skip");
        fruits.stream().skip(4).forEach(System.out::println);

        System.out.println("distinct");
        fruits.stream().distinct().forEach(System.out::println);

        System.out.println("map");
        fruits.stream().map(Fruit::getPrice).forEach(System.out::println);
        fruits.stream().map(Fruit::getPriceAndType).forEach(System.out::println);

        System.out.println("peek");
        fruits.stream().peek(System.out::println).map(Fruit::getPrice).forEach(System.out::println);

        System.out.println("limit");
        fruits.stream().limit(4).forEach(System.out::println);

        Comparator<Fruit> fruitComparator = new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                int result = o1.getFruitType().toString().compareTo(o2.getFruitType().toString());

                if (result == 0) {
                    result = o1.getPrice() - o2.getPrice();
                }
                return result;
            }
        };

        System.out.println("sorted");
        fruits.stream().sorted(Comparator.comparing(Fruit::getPrice)).forEach(System.out::println);
        System.out.println("____");
        fruits.stream().sorted(fruitComparator).forEach(System.out::println);

        System.out.println("mapToDouble");
        fruits.stream().mapToDouble(Fruit::getPrice).forEach(System.out::println);

        System.out.println("flatMap");
        fruits.stream().map(Fruit::getVitamins).flatMap(Collection::stream).distinct().forEach(System.out::println);
        fruits.stream().flatMap(a -> Stream.of(a.getFruitType())).distinct().forEach(System.out::println);
        fruits.stream().flatMap(fr -> fr.getVitamins().stream()).distinct().forEach(System.out::println);

        // table 2.2
        System.out.println("findFirst");
        Fruit result2 = fruits.stream().findFirst().orElse(fruits.get(1));
        Optional<Fruit> optionalFruit = fruits.stream().findFirst();
        System.out.println(result2);
        System.out.println(optionalFruit);

        System.out.println("findAny");
        fruits.stream().findAny().ifPresent(System.out::println);
        System.out.println(fruits.stream().findAny().get());

        System.out.println("count");
        System.out.println(fruits.stream().filter(a -> a.getFruitType().equals(APPLE)).count());

        System.out.println("anyMatch");
        System.out.println(fruits.stream().anyMatch(a -> a.getPrice() > 20));

        System.out.println("noneMatch");
        System.out.println(fruits.stream().noneMatch(a -> a.getPrice() > 60));

        System.out.println("allMatch");
        System.out.println(fruits.stream().allMatch(a -> a.getPrice() > 0));

        System.out.println("min");
        System.out.println(fruits.stream().min(Comparator.comparing(Fruit::getPrice)).get());

        System.out.println("max");
        System.out.println(fruits.stream().max(Comparator.comparing(Fruit::getPrice)).get());

        System.out.println("forEach");
        fruits.parallelStream().forEach(System.out::println);

        System.out.println("forEachOrdered");
        fruits.stream().skip(2).forEachOrdered(System.out::println);

        System.out.println("toArray");
        System.out.println(Arrays.toString(fruits.stream().map(Fruit::getPrice).toArray(Integer[]::new)));
        System.out.println(Arrays.toString(fruits.stream().map(Fruit::getFruitType).toArray(FruitType[]::new)));
        System.out.println(Arrays.toString(fruits.stream().map(Fruit::getVitamins).toArray(List[]::new)));

        System.out.println("reduce");
        System.out.println(fruits.stream().map(Fruit::getPrice).reduce(0, Integer::sum));


    }

    private static List<Fruit> fillFruitsList() {

        List<Fruit> fruits = new ArrayList<>();


        Fruit fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);

        fruit.setVitamins(Arrays.asList(new Vitamins[]{B, C}));

        fruits.add(fruit);


        fruit = new Fruit(STRAWBERRY, 15, LocalDate.of(2019, 1, 2), 50, null);

        fruit.setVitamins(Arrays.asList(new Vitamins[]{A, C}));

        fruits.add(fruit);


        fruit = new Fruit(PEAR, 30, LocalDate.of(2019, 1, 4), 40, null);

        fruit.setVitamins(Arrays.asList(new Vitamins[]{A, B1, B2, C}));

        fruits.add(fruit);


        fruit = new Fruit(ORANGE, 60, LocalDate.of(2019, 1, 3), 30, null);

        fruit.setVitamins(Arrays.asList(new Vitamins[]{E, B, A}));

        fruits.add(fruit);


        fruit = new Fruit(STRAWBERRY, 25, LocalDate.of(2019, 1, 2), 60, null);

        fruit.setVitamins(Arrays.asList(new Vitamins[]{A, C, D}));

        fruits.add(fruit);


        fruit = new Fruit(PEAR, 15, LocalDate.of(2019, 1, 4), 40, null);

        fruit.setVitamins(Arrays.asList(new Vitamins[]{A, B, B1, B2, P}));

        fruits.add(fruit);


        fruit = new Fruit(PEAR, 5, LocalDate.of(2019, 1, 6), 10, null);

        fruit.setVitamins(Arrays.asList(new Vitamins[]{B1, B2, P}));

        fruits.add(fruit);


        fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);

        fruit.setVitamins(Arrays.asList(new Vitamins[]{B, C}));

        fruits.add(fruit);


        return fruits;

    }

}