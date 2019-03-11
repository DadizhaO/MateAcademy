package HM26.beans;

import org.springframework.stereotype.Component;

@Component("truck")
public class Truck extends Transport {
    @Override
    public void moveForward() {
        System.out.println("Truck is moving forward slowly…");
    }
}
