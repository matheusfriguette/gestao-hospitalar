package app.models;

import java.io.Serializable;
import java.util.Date;

/*
 * Gerente
 */
public class Gerente extends Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    private static long serialUID = 1L; 
    private String id;

    /*
     * Construtores
     */
    public Gerente() {
        super(null, null, null, null, null, null, null, null, null, null);
        setId(Long.toString(serialUID++));
    }

    public Gerente(String login, String senha, String nctps, Date dataAdmissao, String cpf, String rg, String nome,
            String telefone, Date dataNascimento, Endereco endereco) {
        super(login, senha, nctps, dataAdmissao, cpf, rg, nome, telefone, dataNascimento, endereco);
        setId(Long.toString(serialUID++));
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