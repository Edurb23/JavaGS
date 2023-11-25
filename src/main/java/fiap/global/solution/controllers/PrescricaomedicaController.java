package fiap.global.solution.controllers;

import fiap.global.solution.models.Prescricaomedica;
import fiap.global.solution.repositores.PrescricaomedicaRepository;
import fiap.global.solution.services.PrescricaodataService;
import fiap.global.solution.services.PrescricaomedicaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;


@Path("/prescricaomedica")
public class PrescricaomedicaController {

    private final PrescricaomedicaRepository repository = new PrescricaomedicaRepository();
    private final PrescricaomedicaService prescricaomedicaService = new PrescricaomedicaService();
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPrescricaomedica(Prescricaomedica prescricaomedica) throws SQLException
    {
        Response service = prescricaomedicaService.validaPrescricao(prescricaomedica);

        if (service.getStatus() != Response.Status.OK.getStatusCode()){
            return service;
        }

        repository.add(prescricaomedica);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prescricaomedica getPrescricaomedica(@PathParam("id") int id) throws SQLException{
        return repository.find(id).orElse(null);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<ArrayList<Prescricaomedica>> getPrescricaomedicas() throws SQLException{
        return repository.findAll();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upDatePrescricaomedica(Prescricaomedica prescricaomedica) throws SQLException{
        repository.update(prescricaomedica);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePrescricaomedica(@PathParam("id") int id) throws SQLException
    {
        repository.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
