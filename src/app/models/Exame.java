package app.models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.time.Duration;

import app.dao.ExameDAO;

/*
 * Exame
 */
public class Exame implements Serializable {
    private static final long serialVersionUID = 1L;
    private static long serialUID;
    private String id;
    private String nome;
    private String observacoes;
    private Duration tempoDuracao;
    private Duration tempoResultado;

    /*
     * Construtores
     */
    public Exame() {
        setId(Long.toString(++serialUID));
        setNome(null);
        setObservacoes(null);
        setTempoDuracao(null);
        setTempoResultado(null);
    }

    public Exame(String nome, String observacoes, Duration tempoDuracao, Duration tempoResultado) {
        setId(Long.toString(++serialUID));
        setNome(nome);
        setObservacoes(observacoes);
        setTempoDuracao(tempoDuracao);
        setTempoResultado(tempoResultado);
    }

    static {
        ExameDAO exame = new ExameDAO();
        try {
            serialUID = exame.getLastKey();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public Duration getTempoDuracao() {
        return tempoDuracao;
    }

    public void setTempoDuracao(Duration tempoDuracao) {
        this.tempoDuracao = tempoDuracao;
    }

    public Duration getTempoResultado() {
        return tempoResultado;
    }

    public void setTempoResultado(Duration tempoResultado) {
        this.tempoResultado = tempoResultado;
    }
}