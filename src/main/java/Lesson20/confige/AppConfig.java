package Lesson20.confige;

import Lesson20.AbstractAnimal;
import Lesson20.Cat;
import Lesson20.Dog;
import Lesson20.Mouse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan ("Lesson20")
public class AppConfig {

    @Bean ("cat")
    public Cat returnCat(){
        return new Cat();
    }

    @Bean ("dog")
    @Primary
    public Dog returnDog(){
        return new Dog();
    }

    @Bean ("mouse")
    public Mouse returnMouse(){
        return new Mouse();
    }

    @Bean("pig")
    public Pig returnPig(){
        Pig pig = new Pig();
        pig.setColour("violet");
        return pig;
    }

@Component("pig2")
    public class Pig extends AbstractAnimal{
        private String colour = "Ping";

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
        public String getVoice() {
            return "Hru-hru";
        }

    @Override
    public String toString() {
        return "Pig{" + super.toString() +
                "colour='" + colour + '\'' +
                '}';
    }
}


}
