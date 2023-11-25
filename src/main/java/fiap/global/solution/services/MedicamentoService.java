package fiap.global.solution.services;

import fiap.global.solution.models.Emailpaciente;
import fiap.global.solution.models.Medicamento;
import jakarta.ws.rs.core.Response;

public class MedicamentoService {
    public boolean medicamnetoValido(long codigobarras) {
        String textoCodigoBarras = String.valueOf(codigobarras);
        return textoCodigoBarras.matches("\\d{11}");
}
    public Response validaCodigobarras(Medicamento medicamento){
        long dadosCodigoBarras = medicamento.getNr_codigo_barras();
        if (!medicamnetoValido(dadosCodigoBarras)){
            return Response.status(Response.Status.BAD_REQUEST).entity("Código de barras incorreto").build();
        }
        return  Response.ok().build();
    }
}
