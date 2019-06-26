package app.models;

import java.io.Serializable;
import java.time.LocalDate;

/*
 * Pessoa
 */
public abstract class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cpf;
    private String rg;
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
    private Endereco endereco;

    /*
     * Construtores
     */
    public Pessoa() {
        setCPF(null);
        setRG(null);
        setNome(null);
        setTelefone(null);
        setDataNascimento(null);
        setEndereco(null);
    }

    public Pessoa(String cpf, String rg, String nome, String telefone, LocalDate dataNascimento, Endereco endereco) {
        setCPF(cpf);
        setRG(rg);
        setNome(nome);
        setTelefone(telefone);
        setDataNascimento(dataNascimento);
        setEndereco(endereco);
    }

    /*
     * Gets e sets
     */
    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getRG() {
        return rg;
    }

    public void setRG(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}