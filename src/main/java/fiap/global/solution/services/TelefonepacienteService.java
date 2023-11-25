package fiap.global.solution.services;

import fiap.global.solution.models.Telefonepaciente;
import jakarta.ws.rs.core.Response;

public class TelefonepacienteService {
    public boolean telefoneValido(Long telefone) {
        String textoTelefone = String.valueOf(telefone);
        return textoTelefone.matches("\\d{9}");
    }
    public Response validarTelefone(Telefonepaciente telefonepaciente){
        Long dadosTelefone = telefonepaciente.getNr_telefone();
        if (!telefoneValido(dadosTelefone)){
            return Response.status(Response.Status.BAD_REQUEST).entity("Formato de telefone inválido, tente um número válido").build();
        }
        return  Response.ok().build();
    }
}
