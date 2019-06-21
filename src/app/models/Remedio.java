package app.models;

import java.io.Serializable;
import java.util.UUID;

/*
 * Remedio
 */
public class Remedio implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String nome;
    private String observacoes;
    private Integer quantidadeDisponivel;
    private Double preco;

    /*
     * Construtores
     */
    public Remedio() {
        setId(UUID.randomUUID().toString());
        setNome(null);
        setObservacoes(null);
        setQuantidadeDisponivel(null);
        setPreco(null);
    }

    public Remedio(String nome, String observacoes, Integer quantidadeDisponivel, Double preco) {
        setId(UUID.randomUUID().toString());
        setNome(nome);
        setObservacoes(observacoes);
        setQuantidadeDisponivel(quantidadeDisponivel);
        setPreco(preco);
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

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}