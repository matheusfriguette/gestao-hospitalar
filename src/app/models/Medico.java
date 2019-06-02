package models;

/*
 * Medico
 */
public class Medico extends Funcionario {
    private String CRM;
    private String Especialidade;

    /*
     * Construtores
     */
    public Medico() {
        super(null, null, null, null, null, null, null, null, null);
        setCRM(null);
        setEspecialidade(null);
    }

    public Medico(String CRM, String especialidade, String login, String senha, String NCTPS, String dataAdmissao,
            String CPF, String RG, String nome, String telefone, String dataNascimento) {
        super(login, senha, NCTPS, dataAdmissao, CPF, RG, nome, telefone, dataNascimento);
        setCRM(CRM);
        setEspecialidade(especialidade);
    }

    /*
     * Gets e sets
     */
    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getEspecialidade() {
        return Especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.Especialidade = especialidade;
    }
}