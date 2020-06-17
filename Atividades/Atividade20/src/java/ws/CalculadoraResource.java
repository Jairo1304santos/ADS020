package ws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("calculadora")
public class CalculadoraResource {

    @Context
    private UriInfo context;

     @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public int somar(@QueryParam(value = "a") int a, @QueryParam(value = "b") int b) {
        return a + b;
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public int subtrair(@QueryParam(value = "a") int a, @QueryParam(value = "b") int b) {
        return a - b;
    }
    
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public int multiplicar(@QueryParam(value = "a") int a, @QueryParam(value = "b") int b) {
        return a * b;
    }
    
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public int dividir(@QueryParam(value = "a") int a, @QueryParam(value = "b") int b) {
        return a / b;
    }
    
    
    
    public CalculadoraResource() {
    }

    /**
     * Retrieves representation of an instance of ws.CalculadoraResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of CalculadoraResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
