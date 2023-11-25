package fiap.global.solution.services;

import fiap.global.solution.models.Prescricaomedica;
import fiap.global.solution.models.Recomendacao;
import jakarta.ws.rs.core.Response;

public class RecomendacaoService {
    public boolean validador(String dados) {

        return dados.matches("^.{100,}$");
}
    public Response validaRecomendacao(Recomendacao recomendacao){
        String dados = recomendacao.getDs_recomendacao();
        if (!validador(dados)){
            return Response.status(Response.Status.BAD_REQUEST).entity("Recomendação incompleta, Pelo menos 100 caracteres, são necessários\"").build();
        }
        return  Response.ok().build();
    }
}
