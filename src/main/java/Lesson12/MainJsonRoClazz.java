package Lesson12;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MainJsonRoClazz {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            MateGroup mateGroup = mapper.readValue(new File("src/main/resources/mateGroup.json"),
                    MateGroup.class);
            System.out.println(mateGroup);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
