package fiap.global.solution.controllers;


import fiap.global.solution.models.Prescricaodata;
import fiap.global.solution.repositores.PrescricaodataRepository;
import fiap.global.solution.services.EmailpacienteService;
import fiap.global.solution.services.PrescricaodataService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;


@Path("/prescricaodata")
public class PrescricaodataController {

    private final PrescricaodataRepository repository = new PrescricaodataRepository();
    private final PrescricaodataService prescricaodataService = new PrescricaodataService();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPrescricaodata(Prescricaodata prescricaodata) throws SQLException
    {
        Response service = prescricaodataService.validaLaudo(prescricaodata);

        if (service.getStatus() != Response.Status.OK.getStatusCode()){
            return service;
        }

        repository.add(prescricaodata);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prescricaodata getPrescricaodata(@PathParam("id") int id) throws SQLException{
        return repository.find(id).orElse(null);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<ArrayList<Prescricaodata>> getPrescricaodatas() throws SQLException{
        return repository.findAll();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upDatePrescricaodata(Prescricaodata prescricaodata) throws SQLException{
        repository.update(prescricaodata);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePrescricaodata(@PathParam("id") int id) throws SQLException
    {
        repository.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
