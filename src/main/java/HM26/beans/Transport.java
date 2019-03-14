package HM26.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:HM26/config.properties")
public abstract class Transport implements Moving {

    @Value("${speed:20}")
    int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public abstract void moveForward();
}
