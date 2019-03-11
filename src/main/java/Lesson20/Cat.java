package Lesson20;

import Lesson20.AbstractAnimal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cat extends AbstractAnimal {

    @Override
    public String getVoice() {
        return "Mur-mur";
    }
}
