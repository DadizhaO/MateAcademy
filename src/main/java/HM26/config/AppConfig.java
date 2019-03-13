package HM26.config;


import HM26.beans.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("HM26.beans")
public class AppConfig {

    @Bean("car")
    public Car returnCar() {
        return new Car();
    }

    @Bean("sportcar")
    public Car returnCar2(){
        Car car = new Car();
         car.setSpeed(300);
         return car;
    }

    @Bean("sportcar2")
    public Car returnCar3(){
        Car car = new Car();
        car.setSpeed(350);
        return car;
    }

    @Bean("bicycle")
    public Bicycle returnBicycle() {
        Bicycle bicycle = new Bicycle();
        bicycle.setSpeed(60);
        return bicycle;
    }

    @Bean("motorcycle")
    public Motorcycle returnMotorcycle() {
        return new Motorcycle();
    }

    @Bean("truck")
    public Truck returnTruck() {
        return new Truck();
    }

    @Bean("train")
    public Train returnTrain() {
        return new Train();
    }

}
