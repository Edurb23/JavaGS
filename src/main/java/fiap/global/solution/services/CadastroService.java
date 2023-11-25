package fiap.global.solution.services;

import fiap.global.solution.models.Cadastro;
import jakarta.ws.rs.core.Response;

public class CadastroService {
    public boolean senhaValida(String senha) {
        return senha.matches("^(?=(?:.*[a-z]){2,})(?=(?:.*[A-Z]){2,})(?=(?:.*\\d){2,})(?=(?:.*[^\\w\\d]){1,}).{8,}$");
    }

    public Response validarCadastro(Cadastro cadastro){
        String senhaCadastro = cadastro.getCd_senha();
        if (!senhaValida(senhaCadastro)){
            return Response.status(Response.Status.BAD_REQUEST).entity("Senha inválida, é necessário pelo menos 8 caracteres, sendo necessário pelo menos 2 letras maiúculas, 2 letras Minusculas e 2 números e pelo menos um caracter especial").build();
        }
        return  Response.ok().build();
    }
}
