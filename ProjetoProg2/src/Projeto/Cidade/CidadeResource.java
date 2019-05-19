
package Projeto.Cidade;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.dropwizard.jersey.params.*;
import java.util.*;


@Path("/Cidades")
@Produces(MediaType.APPLICATION_JSON)
public class CidadeResource {
    private DataAccessObjectDB dao;
    
    public CidadeResource(DataAccessObjectDB dao){
        this.dao=dao;
    }
    @POST
    public Cidade create(Cidade cdd) {
        return this.dao.create(cdd);
    }
    @GET
    public ArrayList<Cidade>readAll(){
        return dao.readAll();
    }
    @GET
    @Path("{id}")
    public Cidade read(@PathParam("id") LongParam id){
        Long idCidade = id.get();
        return dao.read(idCidade);
    } 
 @PUT
    @Path("{id}")
    public Cidade update(@PathParam("id") LongParam id, Cidade cdd) {
        for (Cidade cidade: dao.readAll()) {
            if (cidade.getId() == id.get()) {
                cidade.setNome(cdd.getNome());
                cidade.setEstado(cdd.getEstado());
                cidade.setPais(cdd.getPais());
                cidade.setPopulacao(cdd.getPopulacao());
                cidade.setId(cdd.getId());
                return cidade;
            }
        }
        return null;
    }
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") LongParam id) {
        Cidade p = null;
        for (Cidade cidade: dao.readAll()) {
            if (cidade.getId() == id.get()) {
                p = cidade;
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
