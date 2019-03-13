package Lesson21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@DependsOn("pig")
public class Tiger {

    @Autowired
    @Qualifier(value = "pig")
    private Pig pig /*= new Pig() {

        public String getVoice() {
            return "HRUUUU";
        }
    }*/;

    private String voice;

    public Tiger() {
    }

    /*public Tiger(Pig pig ) {
        this.pig = pig;
    }*/

    public Pig getPig() {
        return pig;
    }


    public void setPig(Pig pig) {
        this.pig = pig;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String toString() {
        return "Tiger say " + getVoice()
                + (Objects.nonNull(pig) ? " that pig said:" + pig.getVoice() : "");
    }
}
