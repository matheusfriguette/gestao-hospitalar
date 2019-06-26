package app.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/*
 * Medico
 */
public class Medico extends Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String crm;
    private String especialidade;

    /*
     * Construtores
     */
    public Medico() {
        super(null, null, null, null, null, null, null, null, null, null);
        setCRM(null);
        setEspecialidade(null);
    }

    public Medico(String crm, String especialidade, String login, String senha, String nctps, LocalDate dataAdmissao,
            String cpf, String rg, String nome, String telefone, LocalDate dataNascimento, Endereco endereco) {
        super(login, senha, nctps, dataAdmissao, cpf, rg, nome, telefone, dataNascimento, endereco);
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