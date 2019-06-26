package app.models;

import java.io.Serializable;
import java.util.UUID;

/*
 * Plano
 */
public class Plano implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String nome;
    private int consultasDisponiveis;
    private double valor;
    private int idadeMinima;
    private int idadeMaxima;

    /*
     * Construtores
     */
    public Plano() {
        setId(UUID.randomUUID().toString());
        setNome(null);
        setConsultasDisponiveis(0);
        setValor(0);
        setIdadeMinima(0);
        setIdadeMaxima(0);
    }

    public Plano(String nome, int consultasDisponiveis, double valor, int idadeMinima, int idadeMaxima) {
        setId(UUID.randomUUID().toString());
        setNome(nome);
        setConsultasDisponiveis(consultasDisponiveis);
        setValor(valor);
        setIdadeMinima(idadeMinima);
        setIdadeMaxima(idadeMaxima);
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

    public int getConsultasDisponiveis() {
        return consultasDisponiveis;
    }

    public void setConsultasDisponiveis(int consultasDisponiveis) {
        this.consultasDisponiveis = consultasDisponiveis;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getIdadeMinima() {
        return idadeMinima;
    }

    public void setIdadeMinima(int idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    public int getIdadeMaxima() {
        return idadeMaxima;
    }

    public void setIdadeMaxima(int idadeMaxima) {
        this.idadeMaxima = idadeMaxima;
    }

    @Override
    public String toString() {
        return nome + " - R$ " + valor;
    }
}