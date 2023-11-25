package fiap.global.solution.models;

import java.time.LocalDate;

public class Paciente {
    private long id_paciente;
    private String nm_paciente;
    private String nr_cpf;
    private String nr_rg;
    private String fl_sexo_biologico;
    private Float nr_altura;
    private Float nr_peso;
    private LocalDate dt_nascimento;

    public Paciente() {
    }

    public Paciente(long id_paciente, String nm_paciente, String nr_cpf, String nr_rg, String fl_sexo_biologico, Float nr_altura, Float nr_peso, LocalDate dt_nascimento) {
        this.id_paciente = id_paciente;
        this.nm_paciente = nm_paciente;
        this.nr_cpf = nr_cpf;
        this.nr_rg = nr_rg;
        this.fl_sexo_biologico = fl_sexo_biologico;
        this.nr_altura = nr_altura;
        this.nr_peso = nr_peso;
        this.dt_nascimento= dt_nascimento;
    }

    public long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNm_paciente() {
        return nm_paciente;
    }

    public void setNm_paciente(String nm_paciente) {
        this.nm_paciente = nm_paciente;
    }

    public String getNr_cpf() {
        return nr_cpf;
    }

    public void setNr_cpf(String nr_cpf) {
        this.nr_cpf = nr_cpf;
    }

    public String getNr_rg() {
        return nr_rg;
    }

    public void setNr_rg(String nr_rg) {
        this.nr_rg = nr_rg;
    }

    public String getFl_sexo_biologico() {
        return fl_sexo_biologico;
    }

    public void setFl_sexo_biologico(String fl_sexo_biologico) {
        this.fl_sexo_biologico = fl_sexo_biologico;
    }

    public Float getNr_altura() {
        return nr_altura;
    }

    public void setNr_altura(Float nr_altura) {
        this.nr_altura = nr_altura;
    }

    public Float getNr_peso() {
        return nr_peso;
    }

    public void setNr_peso(Float nr_peso) {
        this.nr_peso = nr_peso;
    }

    public LocalDate getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(LocalDate dt_cadastro) {
        this.dt_nascimento = dt_cadastro;
    }
}
