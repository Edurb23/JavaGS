package fiap.global.solution.models;

public class Cadastro {
    private long id_cadastro;
    private long id_paciente;
    private long id_email;
    private String cd_senha;

    public Cadastro() {
    }

    public Cadastro(long id_cadastro, long id_paciente, long id_email, String cd_senha) {
        this.id_cadastro = id_cadastro;
        this.id_paciente = id_paciente;
        this.id_email = id_email;
        this.cd_senha = cd_senha;
    }

    public long getId_cadastro() {
        return id_cadastro;
    }

    public void setId_cadastro(long id_cadastro) {
        this.id_cadastro = id_cadastro;
    }

    public long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public long getId_email() {
        return id_email;
    }

    public void setId_email(long id_email) {
        this.id_email = id_email;
    }

    public String getCd_senha() {
        return cd_senha;
    }

    public void setCd_senha(String cd_senha) {
        this.cd_senha = cd_senha;
    }
}
