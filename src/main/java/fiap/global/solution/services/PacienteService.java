package fiap.global.solution.services;

import fiap.global.solution.models.Medico;
import fiap.global.solution.models.Paciente;
import jakarta.ws.rs.core.Response;

public class PacienteService {
    public boolean validaRg(String rg) {
        return rg.matches("^.{9}$");
    }
    public boolean validaCpf(String cpf) {
        return cpf.matches("^.{9,11}$");
    }
    public boolean validaNome(String nome) {
        return nome.matches("^[A-Za-z]+ [A-Za-z]+$");
    }


    public Response validaPaciente(Paciente paciente){
        String rg = paciente.getNr_rg();
        String cpf = paciente.getNr_cpf();
        String nome = paciente.getNm_paciente();

        String resposta = "Erro na nos dados imputados:";
        int erros = 0;
        if (!validaRg(rg)){
            resposta += " RG inválido;";
            erros +=1;
        }

        if (!validaCpf(cpf)){
            resposta += " CPF inválido;";
            erros +=1;
        }

        if (!validaNome(nome)){
            resposta += " Nome inválido;";
            erros +=1;
        }

        if( erros >0 ){
            return Response.status(Response.Status.BAD_REQUEST).entity(resposta).build();
        }
        return  Response.ok().build();
    }
}
