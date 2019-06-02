package models;

/**
 * Endereco
 */
public class Endereco {
    private String CEP;
    private String Rua;
    private String Numero;
    private String Bairro;
    private String Estado;
    private String Cidade;
    private String Complemento;

    /**
     * Construtores
     */
    public Endereco(){
        setCEP(null);
        setRua(null);
        setNumero(null);
        setBairro(null);
        setEstado(null);
        setCidade(null);
        setComplemento(null);
    }

    public Endereco(String CEP, String Rua, String Numero, String Bairro, String Estado, String Cidade, String Complemento){
        setCEP(CEP);
        setRua(Rua);
        setNumero(Numero);
        setBairro(Bairro);
        setEstado(Estado);
        setCidade(Cidade);
        setComplemento(Complemento);
    }
    
    /**
     * Gets e sets
     */

}