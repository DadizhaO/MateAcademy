package Lesson14;

import Lesson12.Person;

import javax.ws.rs.core.Response;

public interface MateGroupService {

    public Response getMateGroup(int groupId);

    public Response addStudents(int groupId, Person person);
}
