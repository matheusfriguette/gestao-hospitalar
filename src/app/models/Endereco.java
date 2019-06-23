package app.models;

import java.io.Serializable;

/*
 * Endereco
 */
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;

    /*
     * Construtores
     */
    public Endereco() {
        setCEP(null);
        setRua(null);
        setNumero(null);
        setBairro(null);
        setEstado(null);
        setCidade(null);
    }

    public Endereco(String CEP, String estado, String cidade, String bairro, String rua, String numero) {
        setCEP(CEP);
        setEstado(estado);
        setCidade(cidade);
        setBairro(bairro);
        setRua(rua);
        setNumero(numero);
    }

    /*
     * Gets e sets
     */
    public String getCEP() {
        return cep;
    }

    public void setCEP(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}