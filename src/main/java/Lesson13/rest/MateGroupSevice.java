package Lesson13.rest;

import Lesson12.Person;

import javax.ws.rs.core.Response;

public interface MateGroupSevice {

    public Response getMateGroup();

    public Response addStudents(int groupId, Person person);


}
