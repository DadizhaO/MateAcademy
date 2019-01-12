package HM07;

import HM06.FruitType;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal("Barsik", 9);

        Method[] method = animal.getClass().getDeclaredMethods();

        System.out.println(Arrays.toString(method));

        try {
            Method method1 = animal.getClass().getDeclaredMethod("someInternalLogic");
            method1.setAccessible(true);
            method1.invoke(animal);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(animal);

        Constructor[] constructors = animal.getClass().getDeclaredConstructors();
        System.out.println(Arrays.toString(constructors));

        try {
            Constructor constructor = animal.getClass().getDeclaredConstructor();
            constructor.setAccessible(true);
            Animal privateAnimal = (Animal) constructor.newInstance();
            System.out.println(privateAnimal.toString());
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("********");

        //GMO Fruit
        Fruit fruit = new Fruit(FruitType.APPLE, 25, LocalDate.of(2019, 1, 2), 24, null);
        Fruit fruit2 = new Fruit(FruitType.APPLE, 5, LocalDate.of(2019, 5, 2), 34, null);

        List<Fruit> fruits = new ArrayList<>();
        fruits.add(fruit);
        fruits.add(fruit2);
        List<Fruit> gmoFruit = new ArrayList<>();
        try {
            gmoFruit = Fruit.toMakeGMOfruit(fruits);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        gmoFruit.forEach(f -> f.setDayToLive(2));
        gmoFruit.forEach(System.out::println);
        fruits.forEach(System.out::println);

        System.out.println(fruit.dividePrice(0));

        try {
            System.out.println(fruit.dividePrice2(0));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(Fruit.methodCheckedException());

    }

}
