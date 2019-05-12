
package Projeto.Cidade;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.dropwizard.jersey.params.*;
import java.util.*;


@Path("/Aplicativos")
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
    public Cidade update(@PathParam("id") LongParam id,Cidade cdd){
        return null;
    }
}
