package fiap.global.solution.models;

public class Emailpaciente {
    private long id_email;
    private long id_paciente;
    private String ds_email;
    private String st_email;

    public Emailpaciente() {
    }

    public Emailpaciente(long id_email, long id_paciente, String ds_email, String st_email) {
        this.id_email = id_email;
        this.id_paciente = id_paciente;
        this.ds_email = ds_email;
        this.st_email = st_email;
    }

    public long getId_email() {
        return id_email;
    }

    public void setId_email(long id_email) {
        this.id_email = id_email;
    }

    public long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getDs_email() {
        return ds_email;
    }

    public void setDs_email(String ds_email) {
        this.ds_email = ds_email;
    }

    public String getSt_email() {
        return st_email;
    }

    public void setSt_email(String st_email) {
        this.st_email = st_email;
    }
}
