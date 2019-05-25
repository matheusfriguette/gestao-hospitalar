package app;

import java.text.SimpleDateFormat;
// import java.util.Calendar;
import java.util.Date;

/**
 * Pessoa
 */
public class Pessoa {
    private String CPF;
    private String RG;
    private String Nome;
    private String Telefone;
    private Date DataNascimento;

    public Pessoa() {
        setCPF(null);
        setRG(null);
        setNome(null);
        setTelefone(null);
        setDataNascimento(null);
    }

    public Pessoa(String CPF, String RG, String Nome, String Telefone, String DataNascimento) {
        setCPF(CPF);
        setRG(RG);
        setNome(Nome);
        setTelefone(Telefone);
        setDataNascimento(DataNascimento);
    }

    protected SimpleDateFormat pattern = new SimpleDateFormat("dd/MM/yyyy");
    protected SimpleDateFormat patternHoras = new SimpleDateFormat("HH:mm");

    /**
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    private void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * @return the RG
     */
    public String getRG() {
        return RG;
    }

    /**
     * @param RG the RG to set
     */
    private void setRG(String RG) {
        this.RG = RG;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    private void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the Telefone
     */
    public String getTelefone() {
        return Telefone;
    }

    /**
     * @param Telefone the Telefone to set
     */
    private void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    /**
     * @return the DataNascimento
     */
    public Date getDataNascimento() {
        return DataNascimento;
    }

    /**
     * @param DataNascimento the DataNascimento to set
     */
    private void setDataNascimento(String DataNascimento) {
        this.DataNascimento = pattern.parse(DataNascimento);
    }
}
