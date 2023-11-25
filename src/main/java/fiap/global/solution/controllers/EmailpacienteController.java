package fiap.global.solution.controllers;


import fiap.global.solution.models.Emailpaciente;
import fiap.global.solution.repositores.EmailpacienteRepository;
import fiap.global.solution.repositores.PacienteRepository;
import fiap.global.solution.services.EmailpacienteService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;


@Path("/emailpaciente")
public class EmailpacienteController {

    private final EmailpacienteRepository repository = new EmailpacienteRepository();
    private final EmailpacienteService emailpacienteService = new EmailpacienteService();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmailpaciente(Emailpaciente emailpaciente) throws SQLException
    {

        Response service = emailpacienteService.validarEmail(emailpaciente);

        if (service.getStatus() != Response.Status.OK.getStatusCode()){
            return service;
        }

        repository.add(emailpaciente);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Emailpaciente getEmailpaciente(@PathParam("id") int id) throws SQLException{
        return repository.find(id).orElse(null);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<ArrayList<Emailpaciente>> getEmailpaciente() throws SQLException{
        return repository.findAll();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upDateEmailpaciente(Emailpaciente emailpaciente) throws SQLException{
        repository.update(emailpaciente);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteEmailpaciente(@PathParam("id") int id) throws SQLException
    {
        repository.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
