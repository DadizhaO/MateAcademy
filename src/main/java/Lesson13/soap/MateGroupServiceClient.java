package Lesson13.soap;

import Lesson12.Person;
import Lesson12.Student;
import Lesson12.Teacher;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MateGroupServiceClient {
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9999/ws/mate?wsdl");

        // 1st argument service URI, refer to wsdl document above
        // 2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://soap.Lesson13/", "MateGroupServiceImplService");

        Service service = Service.create(url, qname);

        MateGroupService hello = service.getPort(MateGroupService.class);

        System.out.println(hello.getMateGroup());

        List<Person> persons = new ArrayList<>();
        persons.add(new Student("First", "First", 1995));
        persons.add(new Teacher("Second", "Second", 1990, 666));
        System.out.println(hello.addStudents(persons));

    }

}
