package fiap.global.solution.models;

public class Medico {
    private long id_medico;
    private String nm_medico;
    private long nr_crm;
    private String ds_especialidade;
    private String nr_rg;
    private String fl_sexo_biologico;

    public Medico() {
    }

    public Medico(long id_medico, String nm_medico, long nr_crm, String ds_especialidade, String nr_rg, String fl_sexo_biologico) {
        this.id_medico = id_medico;
        this.nm_medico = nm_medico;
        this.nr_crm = nr_crm;
        this.ds_especialidade = ds_especialidade;
        this.nr_rg = nr_rg;
        this.fl_sexo_biologico = fl_sexo_biologico;
    }

    public long getId_medico() {
        return id_medico;
    }

    public void setId_medico(long id_medico) {
        this.id_medico = id_medico;
    }

    public String getNm_medico() {
        return nm_medico;
    }

    public void setNm_medico(String nm_medico) {
        this.nm_medico = nm_medico;
    }

    public long getNr_crm() {
        return nr_crm;
    }

    public void setNr_crm(long nr_crm) {
        this.nr_crm = nr_crm;
    }

    public String getDs_especialidade() {
        return ds_especialidade;
    }

    public void setDs_especialidade(String ds_especialidade) {
        this.ds_especialidade = ds_especialidade;
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
}
