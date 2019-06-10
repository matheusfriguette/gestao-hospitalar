package app.models;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Pessoa
 */
public abstract class Pessoa implements Serializable {
    private String cpf;
    private String rg;
    private String nome;
    private String telefone;
    private Date dataNascimento;

    protected static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    protected static SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

    /*
     * Construtores
     */
    public Pessoa() {
        setCPF(null);
        setRG(null);
        setNome(null);
        setTelefone(null);
        setDataNascimento(null);
    }

    public Pessoa(String cpf, String rg, String nome, String telefone, String dataNascimento) {
        setCPF(cpf);
        setRG(rg);
        setNome(nome);
        setTelefone(telefone);
        setDataNascimento(dataNascimento);
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        try {
            this.dataNascimento = formatoData.parse(dataNascimento);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}