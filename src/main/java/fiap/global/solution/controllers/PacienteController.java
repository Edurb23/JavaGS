package fiap.global.solution.controllers;

import fiap.global.solution.models.Paciente;
import fiap.global.solution.repositores.PacienteRepository;
import fiap.global.solution.services.PacienteService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;


@Path("/paciente")
public class PacienteController {

    private final PacienteRepository repository = new PacienteRepository();
    private final PacienteService pacienteService = new PacienteService();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPaciente(Paciente paciente) throws SQLException
    {

        Response service = pacienteService.validaPaciente(paciente);

        if (service.getStatus() != Response.Status.OK.getStatusCode()){
            return service;
        }
        repository.add(paciente);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente getPaciente(@PathParam("id") int id) throws SQLException{
        return repository.find(id).orElse(null);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<ArrayList<Paciente>> getPacientes() throws SQLException{
        return repository.findAll();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upDatePaciente(Paciente paciente) throws SQLException{
        repository.update(paciente);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePaciente(@PathParam("id") int id) throws SQLException
    {
        repository.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
