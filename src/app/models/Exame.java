package app.models;

import java.io.Serializable;
import java.util.UUID;

/*
 * Exame
 */
public class Exame implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String nome;
    private String observacoes;
    private int tempoDuracao;
    private int tempoResultado;

    /*
     * Construtores
     */
    public Exame() {
        setId(UUID.randomUUID().toString());
        setNome(null);
        setObservacoes(null);
        setTempoDuracao(0);
        setTempoResultado(0);
    }

    public Exame(String nome, String observacoes, int tempoDuracao, int tempoResultado) {
        setId(UUID.randomUUID().toString());
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

    public int getTempoDuracao() {
        return tempoDuracao;
    }

    public void setTempoDuracao(int tempoDuracao) {
        this.tempoDuracao = tempoDuracao;
    }

    public int getTempoResultado() {
        return tempoResultado;
    }

    public void setTempoResultado(int tempoResultado) {
        this.tempoResultado = tempoResultado;
    }

    @Override
    public String toString() {
        return nome;
    }
}