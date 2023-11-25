package fiap.global.solution.controllers;



import fiap.global.solution.models.Emailpaciente;
import fiap.global.solution.models.Telefonepaciente;
import fiap.global.solution.repositores.TelefonepacienteRepository;
import fiap.global.solution.services.TelefonepacienteService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;


@Path("/telefonepaciente")
public class TelefonepacienteController {

    private final TelefonepacienteRepository repository = new TelefonepacienteRepository();
    private final TelefonepacienteService telefonepacienteService = new TelefonepacienteService();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTelefonepaciente(Telefonepaciente telefonepaciente) throws SQLException
    {
        Response service = telefonepacienteService.validarTelefone(telefonepaciente);
        if (service.getStatus() != Response.Status.OK.getStatusCode()){
            return service;
        }
        repository.add(telefonepaciente);
        return Response.status(Response.Status.CREATED).build();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Telefonepaciente getTelefonepaciente(@PathParam("id") int id) throws SQLException{
        return repository.find(id).orElse(null);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<ArrayList<Telefonepaciente>> getTelefonepaciente() throws SQLException{
        return repository.findAll();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upDateTelefonepaciente(Telefonepaciente telefonepaciente) throws SQLException{
        repository.update(telefonepaciente);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteTelefonepaciente(@PathParam("id") int id) throws SQLException
    {
        repository.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
