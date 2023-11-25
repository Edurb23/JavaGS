package fiap.global.solution.models;

import java.time.LocalDate;

public class Prescricaodata {
    private long id_prescricao_data;
    private long id_prescricao;
    private long id_medico;
    private String ds_laudo_medico;
    private LocalDate dt_inicio;
    private LocalDate dt_fim;

    public Prescricaodata() {
    }

    public Prescricaodata(long id_prescricao_data, long id_prescricao, long id_medico, String ds_laudo_medico, LocalDate dt_inicio, LocalDate dt_fim) {
        this.id_prescricao_data = id_prescricao_data;
        this.id_prescricao = id_prescricao;
        this.id_medico = id_medico;
        this.ds_laudo_medico = ds_laudo_medico;
        this.dt_inicio = dt_inicio;
        this.dt_fim = dt_fim;
    }

    public long getId_prescricao_data() {
        return id_prescricao_data;
    }

    public void setId_prescricao_data(long id_prescricao_data) {
        this.id_prescricao_data = id_prescricao_data;
    }

    public long getId_prescricao() {
        return id_prescricao;
    }

    public void setId_prescricao(long id_prescricao) {
        this.id_prescricao = id_prescricao;
    }

    public long getId_medico() {
        return id_medico;
    }

    public void setId_medico(long id_medico) {
        this.id_medico = id_medico;
    }

    public String getDs_laudo_medico() {
        return ds_laudo_medico;
    }

    public void setDs_laudo_medico(String ds_laudo_medico) {
        this.ds_laudo_medico = ds_laudo_medico;
    }

    public LocalDate getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(LocalDate dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public LocalDate getDt_fim() {
        return dt_fim;
    }

    public void setDt_fim(LocalDate dt_fim) {
        this.dt_fim = dt_fim;
    }
}
