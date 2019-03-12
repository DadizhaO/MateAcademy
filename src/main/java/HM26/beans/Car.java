package HM26.beans;

import org.springframework.stereotype.Component;

@Component("car")
public class Car extends Transport {
    @Override
    public void moveForward() {
        System.out.println("Car is moving forward");
    }
}
