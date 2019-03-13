package Lesson21;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("pig")
@PropertySource({"classpath:Lesson21/pig.properties"})
public class Pig {
    @Value("${voice2:hru}")
    private String voice;

    public String getVoice() {
        return voice;
    }

    public String toString() {
        return "Pig say " + getVoice();
    }

}
