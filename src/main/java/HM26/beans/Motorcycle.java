package HM26.beans;

import org.springframework.stereotype.Component;

@Component
public class Motorcycle extends Transport {

    @Override
    public void moveForward() {
        System.out.println("Motorcycle is moving forward");
    }
}
