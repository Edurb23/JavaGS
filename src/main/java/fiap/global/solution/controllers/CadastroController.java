package fiap.global.solution.controllers;

import fiap.global.solution.models.Cadastro;
import fiap.global.solution.models.Login;
import fiap.global.solution.repositores.CadastroRepository;
import fiap.global.solution.services.CadastroService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;


@Path("/cadastro")
public class CadastroController {

    private final CadastroRepository repository = new CadastroRepository();

    private CadastroService cadastroService = new CadastroService();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCadastro(Cadastro cadastro) throws SQLException
    {

        Response service = cadastroService.validarCadastro(cadastro);

        if(service.getStatus() != Response.Status.OK.getStatusCode()){
            return service;
        }
        repository.add(cadastro);
        return Response.status(Response.Status.CREATED).build();
    }
    @POST
    @Path("/getuser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Cadastro addCadastro(Login login) throws SQLException
    {
        return repository.getUser(login);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cadastro getCadastro(@PathParam("id") int id) throws SQLException{
        return repository.find(id).orElse(null);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<ArrayList<Cadastro>> getCadastros() throws SQLException{
        return repository.findAll();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upDateCadastro(Cadastro cadastro) throws SQLException{
        repository.update(cadastro);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCadastro(@PathParam("id") int id) throws SQLException
    {
        repository.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
