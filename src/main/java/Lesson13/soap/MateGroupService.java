package Lesson13.soap;

import Lesson12.MateGroup;
import Lesson12.Person;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface MateGroupService {
    @WebMethod
    public MateGroup getMateGroup();
    @WebMethod
    public MateGroup addStudents(List<Person> persons);

}
