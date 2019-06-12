package app.models;

import java.util.Date;

/*
 * Funcionario
 */
public abstract class Funcionario extends Pessoa {
    private String login;
    private String senha;
    private String nctps;
    private Date dataAdmissao;

    /*
     * Construtores
     */
    public Funcionario() {
        super(null, null, null, null, null, null);
        setLogin(null);
        setSenha(null);
        setNCTPS(null);
        setDataAdmissao(null);
    }

    public Funcionario(String login, String senha, String nctps, Date dataAdmissao, String cpf, String rg,
            String nome, String telefone, Date dataNascimento, Endereco endereco) {
        super(cpf, rg, nome, telefone, dataNascimento, endereco);
        setLogin(login);
        setSenha(senha);
        setNCTPS(nctps);
        setDataAdmissao(dataAdmissao);
    }

    /*
     * Gets e sets
     */
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNCTPS() {
        return nctps;
    }

    public void setNCTPS(String nctps) {
        this.nctps = nctps;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
}