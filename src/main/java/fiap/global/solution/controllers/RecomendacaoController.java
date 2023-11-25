package fiap.global.solution.controllers;

import fiap.global.solution.models.Recomendacao;
import fiap.global.solution.repositores.RecomendacaoRepository;
import fiap.global.solution.services.PrescricaomedicaService;
import fiap.global.solution.services.RecomendacaoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;


@Path("/recomendacao")
public class RecomendacaoController {

    private final RecomendacaoRepository repository = new RecomendacaoRepository();
    private final RecomendacaoService recomendacaoService = new RecomendacaoService();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRecomendacao(Recomendacao recomendacao) throws SQLException
    {

        Response service = recomendacaoService.validaRecomendacao(recomendacao);

        if (service.getStatus() != Response.Status.OK.getStatusCode()){
            return service;
        }


        repository.add(recomendacao);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Recomendacao getRecomendacao(@PathParam("id") int id) throws SQLException{
        return repository.find(id).orElse(null);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<ArrayList<Recomendacao>> getRecomendacao() throws SQLException{
        return repository.findAll();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upDateRecomendacao(Recomendacao recomendacao) throws SQLException{
        repository.update(recomendacao);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteRecomendacao(@PathParam("id") int id) throws SQLException
    {
        repository.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
