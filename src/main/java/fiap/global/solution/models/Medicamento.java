package fiap.global.solution.models;

public class Medicamento {
    private long id_medicamneto;
    private String nm_medicamneto;
    private String ds_detalhada_medicamento;
    private long nr_codigo_barras;
    private String ds_via;

    public Medicamento() {
    }

    public Medicamento(long id_medicamneto, String nm_medicamneto, String ds_detalhada_medicamento, long nr_codigo_barras, String ds_via) {
        this.id_medicamneto = id_medicamneto;
        this.nm_medicamneto = nm_medicamneto;
        this.ds_detalhada_medicamento = ds_detalhada_medicamento;
        this.nr_codigo_barras = nr_codigo_barras;
        this.ds_via = ds_via;
    }

    public long getId_medicamneto() {
        return id_medicamneto;
    }

    public void setId_medicamneto(long id_medicamneto) {
        this.id_medicamneto = id_medicamneto;
    }

    public String getNm_medicamneto() {
        return nm_medicamneto;
    }

    public void setNm_medicamneto(String nm_medicamneto) {
        this.nm_medicamneto = nm_medicamneto;
    }

    public String getDs_detalhada_medicamento() {
        return ds_detalhada_medicamento;
    }

    public void setDs_detalhada_medicamento(String ds_detalhada_medicamento) {
        this.ds_detalhada_medicamento = ds_detalhada_medicamento;
    }

    public long getNr_codigo_barras() {
        return nr_codigo_barras;
    }

    public void setNr_codigo_barras(long nr_codigo_barras) {
        this.nr_codigo_barras = nr_codigo_barras;
    }

    public String getDs_via() {
        return ds_via;
    }

    public void setDs_via(String ds_via) {
        this.ds_via = ds_via;
    }
}
