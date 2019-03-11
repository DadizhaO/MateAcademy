package Lesson20;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainSpringByPackage {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(
                "Lesson20");

        Cat cat = context.getBean(Cat.class);
        System.out.println(cat);

        Dog dog = (Dog) context.getBean("dog");
        System.out.println(dog);

        Mouse mouse = context.getBean("mouse", Mouse.class);
        System.out.println(mouse);

        Animal animal = context.getBean("dog",Animal.class);
        System.out.println(animal);
    }


}
