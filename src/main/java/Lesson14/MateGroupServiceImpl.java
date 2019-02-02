package Lesson14;

import Lesson12.HumanResource;
import Lesson12.MateGroup;
import Lesson12.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


@Path("/rs/mate/{groupId}")
public class MateGroupServiceImpl implements MateGroupService {
    private static Map<Integer, MateGroup> mateGroups = Arrays.asList(MateGroup.mateGroupExampleCreator()).stream()
            .collect(Collectors.toMap(MateGroup::getId, Function.identity()));

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMateGroup(@PathParam("groupId") int groupId) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            return Response.status(Status.OK).entity(mateGroups.get(groupId)).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @Override
    @PUT
    @Path("/students")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStudents(@PathParam("groupId") int groupId, Person person) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            mateGroup.getStudents().addAll(Arrays.asList(person));
            return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/students/{surname}")
    public Response removeStudents(@PathParam("surname") String surname, @PathParam("groupId") int groupId) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            List<Person> students = mateGroup.getStudents();

            students.removeIf(f -> f.getSurname().equals(surname));
            return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/students/{surname}")
    public Response updateStudebts(@PathParam("groupId") int groupId, @PathParam("surname") String surname, @QueryParam("name") String name) {

        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {

            mateGroup.getStudents().stream().filter(s -> s.getSurname().equals(surname)).forEach(s -> s.setName(name));
            return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @POST
    @Path("/humanResources")
    public Response addHumanResources(@PathParam("groupId") int groupId, HumanResource humanResource) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            mateGroup.getHumanResources().add(humanResource);
            return Response.status(Status.ACCEPTED).entity(mateGroup).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }


    @DELETE
    @Path("/humanResources/{surname}")
    public Response removeHumanResources(@PathParam("groupId") int groupId, @PathParam("surname") String surname) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {

            mateGroup.getHumanResources().removeIf(f -> f.getSurname().equals(surname));
            return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/humanResource/{surname}")
    public Response updateHRyear(@PathParam("groupId") int groupId, @PathParam("surname") String surname,
                                 @QueryParam("startWorkYear") int startWorkYear) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            mateGroup.getHumanResources().stream().filter(h -> h.getSurname().equals(surname)).
                    forEach(humanResource -> humanResource.setStartWorkYear(startWorkYear));
            return Response.status(Status.ACCEPTED).entity(mateGroup.getHumanResources()).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @GET
    @Path("/humanResource")
    public Response getAllHumanResource(@PathParam("groupId") int groupId) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            Set<HumanResource> result = mateGroups.get(groupId).getHumanResources();
            return Response.status(Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }


    @GET
    @Path("/humanResource/{surname}")
    public Response getOneHR(@PathParam("groupId") int groupId, @PathParam("surname") String surname) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {

            Set<HumanResource> humanResource = mateGroups.get(groupId).getHumanResources().stream().filter(humanResource1 -> humanResource1.getSurname().
                    equals(surname)).collect(Collectors.toSet());
            return Response.status(Status.OK).entity(humanResource).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

}