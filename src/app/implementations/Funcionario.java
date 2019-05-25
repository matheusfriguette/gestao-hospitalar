package app;

/**
 * Funcionario
 */
public class Funcionario extends Pessoa implements IFuncionario{
    private String Login;
    private String Senha;
    private String NCTPS;
    private String DataAdmissao;

    public Funcionario (){
        super();
        setLogin(null);
        setSenha(null);
        setNCTPS(null);
        setDataAdmissao(null);
    }

    public Funcionario(String CPF, String RG, String Nome, String Telefone, String DataNascimento, String Login, String Senha, String NCTPS, String DataAdmissao){
        super(CPF, RG, Nome, Telefone, DataNascimento);
        setLogin(Login);
        setSenha(Senha);
        setNCTPS(NCTPS);
        setDataAdmissao(DataAdmissao);
    }
    /**
     * @return the login
     */
    public String getLogin() {
        return Login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String Login) {
        this.Login = Login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return Senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    /**
     * @return the nCTPS
     */
    public String getNCTPS() {
        return NCTPS;
    }

    /**
     * @param NCTPS the nCTPS to set
     */
    public void setNCTPS(String NCTPS) {
        this.NCTPS = NCTPS;
    }

    /**
     * @return the dataAdmissao
     */
    public String getDataAdmissao() {
        return DataAdmissao;
    }

    /**
     * @param dataAdmissao the dataAdmissao to set
     */
    public void setDataAdmissao(String DataAdmissao) {
        this.DataAdmissao = pattern.parse(DataAdmissao);
    }
    
}