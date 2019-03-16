package HM26;

import HM26.beans.Bicycle;
import HM26.beans.Car;
import HM26.beans.Truck;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("HM26.beans");
        Car car = context.getBean("car", Car.class);
        car.moveForward();

        Car sportcar = context.getBean("car", Car.class);
        sportcar.setSpeed(305);
        System.out.println(sportcar.getSpeed());

        Bicycle bicycle = (Bicycle) context.getBean("bicycle2");
        bicycle.moveForward();

        System.out.println("----");
        Truck truck = context.getBean("truck", Truck.class);
        System.out.println(truck.getSpeed());
        truck.setSpeed(50);
        System.out.println(truck.getSpeed());
        truck.moveForward();

        Car car1 = context.getBean("car", Car.class);
        System.out.println(car1.getSpeed());

        Car car2 = context.getBean("car", Car.class);
        System.out.println(car2.getSpeed());

        Car sportCarS = (Car) context.getBean("sportCar");
        System.out.println(sportCarS.getSpeed());

        context.close();

    }


}
