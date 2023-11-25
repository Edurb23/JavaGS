package fiap.global.solution.services;

import fiap.global.solution.models.Medicamento;
import fiap.global.solution.models.Medico;
import jakarta.ws.rs.core.Response;

public class MedicoService {
    public boolean medicoValido(long crm) {
        String textocrm = String.valueOf(crm);
        return textocrm.matches("\\d{10}");
}
    public Response validaCrm(Medico medico){
        long dadosCrm = medico.getNr_crm();
        if (!medicoValido(dadosCrm)){
            return Response.status(Response.Status.BAD_REQUEST).entity("Código de CRM inválidp").build();
        }
        return  Response.ok().build();
    }
}
