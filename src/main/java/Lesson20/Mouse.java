package Lesson20;

import org.springframework.stereotype.Component;

@Component("mouse")
public class Mouse extends AbstractAnimal{


    @Override
    public String getVoice() {
        return "pi-pi";
    }
}
