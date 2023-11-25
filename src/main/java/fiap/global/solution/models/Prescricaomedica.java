package fiap.global.solution.models;

import java.time.LocalDate;

public class Prescricaomedica {
    private long id_prescricao;
    private long id_paciente;
    private long id_medicamento;
    private String ds_posologia;
    private String ds_instrucoes;
    private int qt_medicamento;
    private LocalDate dt_prescricao;

    public Prescricaomedica() {
    }

    public Prescricaomedica(long id_prescricao, long id_paciente, long id_medicamento, String ds_posologia, String ds_instrucoes, int qt_medicamento, LocalDate dt_prescricao) {
        this.id_prescricao = id_prescricao;
        this.id_paciente = id_paciente;
        this.id_medicamento = id_medicamento;
        this.ds_posologia = ds_posologia;
        this.ds_instrucoes = ds_instrucoes;
        this.qt_medicamento = qt_medicamento;
        this.dt_prescricao = dt_prescricao;
    }

    public long getId_prescricao() {
        return id_prescricao;
    }

    public void setId_prescricao(long id_prescricao) {
        this.id_prescricao = id_prescricao;
    }

    public long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public long getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(long id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public String getDs_posologia() {
        return ds_posologia;
    }

    public void setDs_posologia(String ds_posologia) {
        this.ds_posologia = ds_posologia;
    }

    public String getDs_instrucoes() {
        return ds_instrucoes;
    }

    public void setDs_instrucoes(String ds_instrucoes) {
        this.ds_instrucoes = ds_instrucoes;
    }

    public int getQt_medicamento() {
        return qt_medicamento;
    }

    public void setQt_medicamento(int qt_medicamento) {
        this.qt_medicamento = qt_medicamento;
    }

    public LocalDate getDt_prescricao() {
        return dt_prescricao;
    }

    public void setDt_prescricao(LocalDate dt_prescricao) {
        this.dt_prescricao = dt_prescricao;
    }
}
