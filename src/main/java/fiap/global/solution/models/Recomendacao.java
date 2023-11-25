package fiap.global.solution.models;

import java.sql.Date;
import java.time.LocalDate;

public class Recomendacao {
    private long id_recomendacao;
    private long id_prescricao;
    private String tp_recomendacao;
    private String ds_recomendacao;
    private LocalDate dt_inicio;
    private LocalDate dt_fim;

    public Recomendacao() {
    }

    public Recomendacao(long id_recomendacao, long id_prescricao, String tp_recomendacao, String ds_recomendacao, LocalDate dt_inicio, LocalDate dt_fim) {
        this.id_recomendacao = id_recomendacao;
        this.id_prescricao = id_prescricao;
        this.tp_recomendacao = tp_recomendacao;
        this.ds_recomendacao = ds_recomendacao;
        this.dt_inicio = dt_inicio;
        this.dt_fim = dt_fim;
    }

    public long getId_recomendacao() {
        return id_recomendacao;
    }

    public void setId_recomendacao(long id_recomendacao) {
        this.id_recomendacao = id_recomendacao;
    }

    public long getId_prescricao() {
        return id_prescricao;
    }

    public void setId_prescricao(long id_prescricao) {
        this.id_prescricao = id_prescricao;
    }

    public String getTp_recomendacao() {
        return tp_recomendacao;
    }

    public void setTp_recomendacao(String tp_recomendacao) {
        this.tp_recomendacao = tp_recomendacao;
    }

    public String getDs_recomendacao() {
        return ds_recomendacao;
    }

    public void setDs_recomendacao(String ds_recomendacao) {
        this.ds_recomendacao = ds_recomendacao;
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
