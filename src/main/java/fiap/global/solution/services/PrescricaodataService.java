package fiap.global.solution.services;

import fiap.global.solution.models.Medico;
import fiap.global.solution.models.Prescricaodata;
import jakarta.ws.rs.core.Response;

public class PrescricaodataService {
    public boolean validador(String laudo) {

        return laudo.matches("^.{50,}$");
}
    public Response validaLaudo(Prescricaodata prescricaodata){
        String dados = prescricaodata.getDs_laudo_medico();
        if (!validador(dados)){
            return Response.status(Response.Status.BAD_REQUEST).entity("Laudo incompleto").build();
        }
        return  Response.ok().build();
    }
}
