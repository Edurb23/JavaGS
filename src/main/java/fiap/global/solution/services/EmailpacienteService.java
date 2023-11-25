package fiap.global.solution.services;

import fiap.global.solution.models.Emailpaciente;
import jakarta.ws.rs.core.Response;

public class EmailpacienteService {
    public boolean emailValido(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    String emailExemplo = "email@email.com";
    public Response validarEmail(Emailpaciente emailpaciente){
        String dadosEmail = emailpaciente.getDs_email();
        if (!emailValido(dadosEmail)){
            return Response.status(Response.Status.BAD_REQUEST).entity("Formato de e-mail inválido, tente usar com esse exemplo :" + " " + emailExemplo ).build();
        }
        return  Response.ok().build();
    }
}
