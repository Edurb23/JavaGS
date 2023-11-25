package fiap.global.solution.models;

public class Login {
    private String senha;
    private String email;

    public Login() {
    }

    public Login(String senha, String email) {
        this.senha = senha;
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
