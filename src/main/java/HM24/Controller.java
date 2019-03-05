package HM24;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Path("/drugs")
public class Controller {

    private static Products products = new Products();

    private HashMap<Integer, Product> productData = products.getProductsMap();

    @GET
    public Response getAllProducts() {
        if (productData != null) {
            return Response.status(Status.OK).entity(productData).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @GET
    @Path("/{category}")
    public Response getAllByCategoty(@PathParam("category") String category) {
        if (productData != null) {
            List result = productData.values().stream().filter(p -> p.getCategory().equals(category)).collect(Collectors.toList());

            return Response.status(Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{id}")
    public Response updatePrice(@PathParam("id") int id, @QueryParam("price") double price) {
        if (productData != null) {
            productData.values().stream().filter(p -> p.getId() == id).forEach(p -> p.setPrice(price));

            return Response.status(Status.OK).entity(productData).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") int id) {
        if (productData != null) {
            productData.values().removeIf(p -> p.getId() == id);

            return Response.status(Status.OK).entity(productData).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }
}
