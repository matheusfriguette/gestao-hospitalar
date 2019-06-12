package app.models;

import java.io.Serializable;
import java.util.Date;

/*
 * Exame
 */
public class Exame implements Serializable {
    private static final long serialVersionUID = 1L;
    private static long serialUID = 1L;
    private String id;
    private String nome;
    private String observacoes;
    private Date tempoDuracao;
    private Date tempoResultado;

    /*
     * Construtores
     */
    public Exame() {
        setId(Long.toString(serialUID++));
        setNome(null);
        setObservacoes(null);
        setTempoDuracao(null);
        setTempoResultado(null);
    }

    public Exame(String nome, String observacoes, Date tempoDuracao, Date tempoResultado) {
        setId(Long.toString(serialUID++));
        setNome(nome);
        setObservacoes(observacoes);
        setTempoDuracao(tempoDuracao);
        setTempoResultado(tempoResultado);
    }

    /*
     * Gets e sets
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Date getTempoDuracao() {
        return tempoDuracao;
    }

    public void setTempoDuracao(Date tempoDuracao) {
        this.tempoDuracao = tempoDuracao;
    }

    public Date getTempoResultado() {
        return tempoResultado;
    }

    public void setTempoResultado(Date tempoResultado) {
        this.tempoResultado = tempoResultado;
    }
}