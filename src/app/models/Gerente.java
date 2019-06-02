package models;

/*
 * Gerente
 */
public class Gerente extends Funcionario {
    /*
     * Construtores
     */
    public Gerente() {
        super(null, null, null, null, null, null, null, null, null);
    }

    public Gerente(String login, String senha, String NCTPS, String dataAdmissao, String CPF, String RG, String nome,
            String telefone, String dataNascimento) {
        super(login, senha, NCTPS, dataAdmissao, CPF, RG, nome, telefone, dataNascimento);
    }
}