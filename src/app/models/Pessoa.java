package models;

/*
 * Pessoa
 */
public abstract class Pessoa {
    private String CPF;
    private String RG;
    private String Nome;
    private String Telefone;
    private String DataNascimento;

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
        Nome = nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        DataNascimento = dataNascimento;
    }
}