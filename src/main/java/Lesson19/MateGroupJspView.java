package Lesson19;

import Lesson12.MateGroup;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class MateGroupJspView {
    private MateGroup mateGroup = MateGroup.mateGroupExampleCreator();

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public Viewable index(@QueryParam("groupId") String groupId) {


        if (groupId != null && groupId.equals("" + mateGroup.getId())) {
            return new Viewable("/index", mateGroup);
        }
        return new Viewable("/index");
    }
}
