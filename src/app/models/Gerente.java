package app.models;

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

    public Gerente(String login, String senha, String nctps, String dataAdmissao, String cpf, String rg, String nome,
            String telefone, String dataNascimento) {
        super(login, senha, nctps, dataAdmissao, cpf, rg, nome, telefone, dataNascimento);
    }
}