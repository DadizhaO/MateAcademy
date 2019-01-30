package Lesson13.soap;

import Lesson12.MateGroup;
import Lesson12.Person;

import javax.jws.WebService;
import java.util.List;
@WebService(endpointInterface = "Lesson13.soap.MateGroupService")
public class MateGroupServiceImpl implements  MateGroupService {
    private MateGroup mateGroup = MateGroup.mateGroupExampleCreator();
    @Override
    public MateGroup getMateGroup() {
        return mateGroup;
    }

    @Override
    public MateGroup addStudents(List<Person> persons) {
        mateGroup.getStudents().addAll(persons);
        return mateGroup;
    }
}
