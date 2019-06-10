package app.models;

/*
 * Medico
 */
public class Medico extends Funcionario {
    private String crm;
    private String especialidade;

    /*
     * Construtores
     */
    public Medico() {
        super(null, null, null, null, null, null, null, null, null);
        setCRM(null);
        setEspecialidade(null);
    }

    public Medico(String crm, String especialidade, String login, String senha, String nctps, String dataAdmissao,
            String cpf, String rg, String nome, String telefone, String dataNascimento) {
        super(login, senha, nctps, dataAdmissao, cpf, rg, nome, telefone, dataNascimento);
        setCRM(crm);
        setEspecialidade(especialidade);
    }

    /*
     * Gets e sets
     */
    public String getCRM() {
        return crm;
    }

    public void setCRM(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}