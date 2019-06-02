package models;

/*
 * Funcionario
 */
public abstract class Funcionario extends Pessoa {
    private String Login;
    private String Senha;
    private String NCTPS;
    private String DataAdmissao;

    /*
     * Construtores
     */
    public Funcionario() {
        setLogin(null);
        setSenha(null);
        setNCTPS(null);
        setDataAdmissao(null);
    }

    public Funcionario(String login, String senha, String NCTPS, String dataAdmissao) {
        setLogin(login);
        setSenha(senha);
        setNCTPS(NCTPS);
        setDataAdmissao(dataAdmissao);
    }

    /*
     * Gets and sets
     */
    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getNCTPS() {
        return NCTPS;
    }

    public void setNCTPS(String NCTPS) {
        this.NCTPS = NCTPS;
    }

    public String getDataAdmissao() {
        return DataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        DataAdmissao = dataAdmissao;
    }
}