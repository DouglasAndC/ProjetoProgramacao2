
package Projeto.Aplicativo;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.dropwizard.jersey.params.*;
import java.util.*;


@Path("/Aplicativos")
@Produces(MediaType.APPLICATION_JSON)
public class AplicativoResource {
    private DataAccessObjectDB dao;
    
    public AplicativoResource(DataAccessObjectDB dao){
        this.dao=dao;
    }
    @POST
    public Aplicativo create(Aplicativo app) {
        return this.dao.create(app);
    }
    @GET
    public ArrayList<Aplicativo>readAll(){
        return dao.readAll();
    }
    @GET
    @Path("{id}")
    public Aplicativo read(@PathParam("id") LongParam id){
        Long idAplicativo = id.get();
        return dao.read(idAplicativo);
    }
    @PUT
    @Path("{id}")
    public Aplicativo update(@PathParam("id") LongParam id, Aplicativo app) {
        for (Aplicativo aplicativo: dao.readAll()) {
            if (aplicativo.getId() == id.get()) {
                aplicativo.setNome(app.getNome());
                aplicativo.setId(app.getId());
                return aplicativo;
            }
        }
        return null;
    }
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") LongParam id) {
        Aplicativo p = null;
        for (Aplicativo aplicativo: dao.readAll()) {
            if (aplicativo.getId() == id.get()) {
                p = aplicativo;
                break;
            }
        }
        if (p != null) { 
            dao.delete(p);
        }
        else {
            throw new WebApplicationException("Aplicativo com id=" + id.get() 
                                              + " não encontrado!", 404);
        }
        return Response.ok().build();
    }
}
