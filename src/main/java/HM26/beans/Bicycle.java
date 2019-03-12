package HM26.beans;

import org.springframework.stereotype.Component;

@Component("bicycle2")
public class Bicycle extends Transport{
    @Override
    public void moveForward() {
        System.out.println("Bicycle2 is moving forward");
    }
}
