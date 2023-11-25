package fiap.global.solution.controllers;

import fiap.global.solution.models.Medico;


import fiap.global.solution.repositores.MedicoRepository;
import fiap.global.solution.services.MedicoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;


@Path("/medico")
public class MedicoController {

    private final MedicoRepository repository = new MedicoRepository();
    private final MedicoService medicoService = new MedicoService();
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMedico(Medico medico) throws SQLException
    {
        Response service = medicoService.validaCrm(medico);

        if (service.getStatus() != Response.Status.OK.getStatusCode()){
            return service;
        }

        repository.add(medico);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Medico getMedico(@PathParam("id") int id) throws SQLException{
        return repository.find(id).orElse(null);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<ArrayList<Medico>> getMedicos() throws SQLException{
        return repository.findAll();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upDateMedico(Medico medico) throws SQLException{
        repository.update(medico);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteMedico(@PathParam("id") int id) throws SQLException
    {
        repository.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
