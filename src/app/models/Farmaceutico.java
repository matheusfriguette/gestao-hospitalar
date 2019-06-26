package app.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/*
 * Farmaceutico
 */
public class Farmaceutico extends Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    /*
     * Construtores
     */
    public Farmaceutico() {
        super(null, null, null, null, null, null, null, null, null, null);
    }

    public Farmaceutico(String login, String senha, String nctps, LocalDate dataAdmissao, String cpf, String rg,
            String nome, String telefone, LocalDate dataNascimento, Endereco endereco) {
        super(login, senha, nctps, dataAdmissao, cpf, rg, nome, telefone, dataNascimento, endereco);
    }
}