package HM26;

import HM26.beans.Bicycle;
import HM26.beans.Car;
import HM26.beans.Moving;
import HM26.beans.Truck;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("HM26.beans");
        Car car = context.getBean("car", Car.class);
        car.moveForward();

        Moving moving = context.getBean("bicycle", Bicycle.class);
        moving.moveForward();


        Car sportcar = context.getBean("car", Car.class);
        sportcar.setSpeed(305);
        System.out.println(sportcar.getSpeed());

        Bicycle bicycle = (Bicycle) context.getBean("bicycle");
        bicycle.moveForward();

        Truck truck = context.getBean("truck", Truck.class);
        truck.moveForward();

    }


}
