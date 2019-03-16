package HM26.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("car")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Car extends Transport {
    private int speed = 300;

    public Car() {
    }

    public Car(int speed) {
        this.speed = speed;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void moveForward() {
        System.out.println("Car is moving forward");
    }
}
