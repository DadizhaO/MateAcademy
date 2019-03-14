package HM26.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("bicycle2")
public class Bicycle extends Transport {

    private String human;

    @PostConstruct
    private void init() {
        human = "sat down";
        System.out.println("Go, human " + human);
    }

    @PreDestroy
    private void destroyBeen() {
        human = "not found";
        System.out.println("Stop, human " + human + " been destroyed");
    }

    @Override
    public void moveForward() {
        System.out.println("Bicycle2 is moving forward");
    }
}
