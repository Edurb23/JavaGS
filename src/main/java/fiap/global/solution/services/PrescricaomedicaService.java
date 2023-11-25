package fiap.global.solution.services;

import fiap.global.solution.models.Prescricaodata;
import fiap.global.solution.models.Prescricaomedica;
import jakarta.ws.rs.core.Response;

public class PrescricaomedicaService {
    public boolean validador(String dadosPosologia,String dadosInstrucoes) {

        return dadosPosologia.matches("^.{100,}$") && dadosInstrucoes.matches("^.{100,}$");
}
    public Response validaPrescricao(Prescricaomedica prescricaomedica){
        String dadosPosologia = prescricaomedica.getDs_posologia();
        String dadosInstrucoes = prescricaomedica.getDs_instrucoes();
        if (!validador(dadosPosologia,dadosInstrucoes)){
            return Response.status(Response.Status.BAD_REQUEST).entity("Posologia ou Instruções, inclompletos, pelo menos 100 caracteres, são necessários").build();
        }
        return  Response.ok().build();
    }
}
