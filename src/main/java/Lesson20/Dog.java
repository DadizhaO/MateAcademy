package Lesson20;

import org.springframework.stereotype.Component;

@Component("dog2")
public class Dog extends AbstractAnimal {
    @Override
    public String getVoice() {
        return "Gav-gav2";
    }
}
