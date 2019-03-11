package Lesson20;

import Lesson20.confige.AppConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainSpringByConfig {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Cat cat = context.getBean(Cat.class);
        System.out.println(cat);

        Dog dog = context.getBean(Dog.class);
        System.out.println(dog);

        Mouse mouse = context.getBean(Mouse.class);
        System.out.println(mouse);

        System.out.println("--------");

        Dog dog2 = (Dog) context.getBean("dog");
        System.out.println(dog2);

        Mouse mouse2 = context.getBean("mouse", Mouse.class);
        System.out.println(mouse2);

        Animal animal2 = context.getBean("pig", Animal.class);
        System.out.println(animal2);

        AppConfig.Pig pig = (AppConfig.Pig) context.getBean("pig2");
        System.out.println(pig);

        System.out.println("-----");

        Animal animal = context.getBean(Animal.class);
        System.out.println(animal);

        Dog dog1 = context.getBean("dog2", Dog.class);
        System.out.println(dog1);

        Dog dog3 = context.getBean("dog", Dog.class);
        System.out.println(dog3);

      /*  AppConfig.Pig pig2 =  context.getBean( AppConfig.Pig.class);
        System.out.println(pig2);*/



/*        AppConfig.Pig pig1 = (AppConfig.Pig) context.getBean(AppConfig.Pig.class);
        System.out.println(pig1);*/



    }
}
