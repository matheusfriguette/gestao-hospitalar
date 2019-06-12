package app.models;

/*
 * Endereco
 */
public class Endereco {
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;

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
        setComplemento(null);
    }

    public Endereco(String CEP, String estado, String cidade, String bairro, String rua, String numero,
            String complemento) {
        setCEP(CEP);
        setEstado(estado);
        setCidade(cidade);
        setBairro(bairro);
        setRua(rua);
        setNumero(numero);
        setComplemento(complemento);
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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}