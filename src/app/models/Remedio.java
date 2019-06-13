package app.models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import app.dao.RemedioDAO;

/*
 * Remedio
 */
public class Remedio implements Serializable {
    private static final long serialVersionUID = 1L;
    private static long serialUID;
    private String id;
    private String nome;
    private String observacoes;
    private Integer quantidadeDisponivel;
    private Double preco;

    /*
     * Construtores
     */
    public Remedio() {
        setId(Long.toString(++serialUID));
        setNome(null);
        setObservacoes(null);
        setQuantidadeDisponivel(null);
        setPreco(null);
    }

    public Remedio(String nome, String observacoes, Integer quantidadeDisponivel, Double preco) {
        setId(Long.toString(++serialUID));
        setNome(nome);
        setObservacoes(observacoes);
        setQuantidadeDisponivel(quantidadeDisponivel);
        setPreco(preco);
    }

    static {
        RemedioDAO exame = new RemedioDAO();
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