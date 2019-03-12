package HM26;

import HM26.beans.Bicycle;
import HM26.beans.Car;
import HM26.beans.Moving;
import HM26.beans.Truck;
import HM26.config.AppConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfig {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Car car = context.getBean("car", Car.class);
        car.moveForward();

        Moving moving = (Moving) context.getBean("train");
        moving.moveForward();

        Car sportcar = (Car) context.getBean("sportcar");
        System.out.println(sportcar.getSpeed());

        Car sportcar2 = context.getBean("sportcar2", Car.class);
        System.out.println(sportcar2.getSpeed());

        Bicycle bicycle = (Bicycle) context.getBean("bicycle2");
        bicycle.moveForward();

        Bicycle bicy = (Bicycle) context.getBean("bicycle");
        System.out.println(bicy.getSpeed());

        Truck truck = (Truck) context.getBean("truck");
        truck.moveForward();

    }
}
