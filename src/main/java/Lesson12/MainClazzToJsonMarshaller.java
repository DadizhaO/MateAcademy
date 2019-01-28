
package Lesson12;

import org.eclipse.persistence.jaxb.MarshallerProperties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringWriter;

public class MainClazzToJsonMarshaller {
    public static void main(String[] args) {
        MateGroup mateGroup = MateGroup.mateGroupExampleCreator();
        System.setProperty("javax.xml.bind.context.factory", "org.eclipse.persistence.jaxb.JAXBContextFactory");

        try {
            File file = new File("src/main/resources/json/mateGroupMarshaller.json");
            JAXBContext jaxbContext = JAXBContext.newInstance(MateGroup.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
            jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT,false);

            jaxbMarshaller.marshal(mateGroup, file);
            jaxbMarshaller.marshal(mateGroup, System.out);



        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
/*   StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(object, sw);
            System.out.println(sw.toString());*/
/*    jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
            jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);*/