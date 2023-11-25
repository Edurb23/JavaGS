package fiap.global.solution.controllers;

import fiap.global.solution.models.Medicamento;

import fiap.global.solution.repositores.MedicamentoRepository;

import fiap.global.solution.services.EmailpacienteService;
import fiap.global.solution.services.MedicamentoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;


@Path("/medicamento")
public class MedicamentoController {

    private final MedicamentoRepository repository = new MedicamentoRepository();

    private final MedicamentoService medicamentoService = new MedicamentoService();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMedicamento(Medicamento medicamento) throws SQLException
    {
        Response service = medicamentoService.validaCodigobarras(medicamento);

        if (service.getStatus() != Response.Status.OK.getStatusCode()){
            return service;
        }

        repository.add(medicamento);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Medicamento getMedicamento(@PathParam("id") int id) throws SQLException{
        return repository.find(id).orElse(null);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<ArrayList<Medicamento>> getMedicamento() throws SQLException{
        return repository.findAll();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upDateMedicamento(Medicamento medicamento) throws SQLException{
        repository.update(medicamento);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteMedicamento(@PathParam("id") int id) throws SQLException
    {
        repository.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
