package app.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/*
 * Gerente
 */
public class Gerente extends Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    /*
     * Construtores
     */
    public Gerente() {
        super(null, null, null, null, null, null, null, null, null, null);
        setId(UUID.randomUUID().toString());
    }

    public Gerente(String login, String senha, String nctps, Date dataAdmissao, String cpf, String rg, String nome,
            String telefone, Date dataNascimento, Endereco endereco) {
        super(login, senha, nctps, dataAdmissao, cpf, rg, nome, telefone, dataNascimento, endereco);
        setId(UUID.randomUUID().toString());
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
}