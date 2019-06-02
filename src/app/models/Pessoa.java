package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Pessoa
 */
public abstract class Pessoa {
    private String CPF;
    private String RG;
    private String Nome;
    private String Telefone;
    private Date DataNascimento;
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

    public Pessoa(String CPF, String RG, String nome, String telefone, String dataNascimento) {
        setCPF(CPF);
        setRG(RG);
        setNome(nome);
        setTelefone(telefone);
        setDataNascimento(dataNascimento);
    }

    /*
     * Gets and sets
     */
    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        this.Telefone = telefone;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        try {
            this.DataNascimento = formatoData.parse(dataNascimento);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}