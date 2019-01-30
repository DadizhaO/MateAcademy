package Lesson13.rest;

import Lesson12.MateGroup;
import Lesson12.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/rs/mate")
public class MateGroupServiceImpl implements MateGroupSevice {
    private MateGroup mateGroup = MateGroup.mateGroupExampleCreator();

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMateGroup() {
        return Response.status(Status.OK).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
    }

    @Override
    @PUT
    @Path("/{groupId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStudents(@PathParam("groupId") int groupId, Person person) {
        if (groupId == mateGroup.getId()) {
            mateGroup.getStudents().addAll(Arrays.asList(person));
            return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }
}
