package app.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/*
 * Medico
 */
public class Medico extends Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String crm;
    private String especialidade;

    /*
     * Construtores
     */
    public Medico() {
        super(null, null, null, null, null, null, null, null, null, null);
        setId(UUID.randomUUID().toString());
        setCRM(null);
        setEspecialidade(null);
    }

    public Medico(String crm, String especialidade, String login, String senha, String nctps, Date dataAdmissao,
            String cpf, String rg, String nome, String telefone, Date dataNascimento, Endereco endereco) {
        super(login, senha, nctps, dataAdmissao, cpf, rg, nome, telefone, dataNascimento, endereco);
        setId(UUID.randomUUID().toString());
        setCRM(crm);
        setEspecialidade(especialidade);
    }

    /*
     * Gets e sets
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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