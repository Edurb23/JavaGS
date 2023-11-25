package fiap.global.solution.models;

public class Telefonepaciente {
    private long id_telefone;
    private long id_paciente;
    private long nr_ddi;
    private long nr_ddd;
    private long nr_telefone;
    private String nm_operadora;

    public Telefonepaciente() {
    }

    public Telefonepaciente(long id_telefone, long id_paciente, long nr_ddi, long nr_ddd, long nr_telefone, String nm_operadora) {
        this.id_telefone = id_telefone;
        this.id_paciente = id_paciente;
        this.nr_ddi = nr_ddi;
        this.nr_ddd = nr_ddd;
        this.nr_telefone = nr_telefone;
        this.nm_operadora = nm_operadora;
    }

    public long getId_telefone() {
        return id_telefone;
    }

    public void setId_telefone(long id_telefone) {
        this.id_telefone = id_telefone;
    }

    public long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public long getNr_ddi() {
        return nr_ddi;
    }

    public void setNr_ddi(long nr_ddi) {
        this.nr_ddi = nr_ddi;
    }

    public long getNr_ddd() {
        return nr_ddd;
    }

    public void setNr_ddd(long nr_dd) {
        this.nr_ddd = nr_dd;
    }

    public long getNr_telefone() {
        return nr_telefone;
    }

    public void setNr_telefone(long nr_telefone) {
        this.nr_telefone = nr_telefone;
    }

    public String getNm_operadora() {
        return nm_operadora;
    }

    public void setNm_operadora(String nm_operadora) {
        this.nm_operadora = nm_operadora;
    }
}
