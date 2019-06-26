package app.models;

import java.io.Serializable;
import java.time.LocalDate;

/*
 * Gerente
 */
public class Gerente extends Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    /*
     * Construtores
     */
    public Gerente() {
        super(null, null, null, null, null, null, null, null, null, null);
    }

    public Gerente(String login, String senha, String nctps, LocalDate dataAdmissao, String cpf, String rg, String nome,
            String telefone, LocalDate dataNascimento, Endereco endereco) {
        super(login, senha, nctps, dataAdmissao, cpf, rg, nome, telefone, dataNascimento, endereco);
    }
}