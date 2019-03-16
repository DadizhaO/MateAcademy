package HM26.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("truck")
public class Truck extends Transport {
    @Autowired
    Car car;

    @Override
    public int getSpeed() {
        return car.getSpeed();
    }

    @Override
    public void setSpeed(int speed) {
        car.setSpeed(speed);
    }

    @Override
    public void moveForward() {
        System.out.println("Truck is moving forward slowly…");
    }
}
