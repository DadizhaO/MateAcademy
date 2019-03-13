package Lesson21;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainSpring {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(
                "Lesson21");

        Pig pig = context.getBean(Pig.class);
        System.out.println(pig);

        Tiger tiger = (Tiger) context.getBean("tiger", Tiger.class);
        System.out.println(tiger.toString());

        Tiger tiger1 = (Tiger) context.getBean("tiger2");
        System.out.println(tiger1.getVoice());

        Kakadu kakadu = context.getBean(Kakadu.class);
        System.out.println(kakadu);

        Bloha bloha = context.getBean(Bloha.class);
        System.out.println(bloha);
        Bloha bloha2 = context.getBean(Bloha.class);
        System.out.println(bloha2);

        Cat cat = context.getBean(Cat.class);
        System.out.println(cat);

        Cat cat2 = context.getBean(Cat.class);
        System.out.println(cat2);

       // context.close();
    }
}
