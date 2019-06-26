package app.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/*
 * Funcionario
 */
public abstract class Funcionario extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String login;
    private String senha;
    private String nctps;
    private LocalDate dataAdmissao;

    /*
     * Construtores
     */
    public Funcionario() {
        super(null, null, null, null, null, null);
        setId(UUID.randomUUID().toString());
        setLogin(null);
        setSenha(null);
        setNCTPS(null);
        setDataAdmissao(null);
    }

    public Funcionario(String login, String senha, String nctps, LocalDate dataAdmissao, String cpf, String rg,
            String nome, String telefone, LocalDate dataNascimento, Endereco endereco) {
        super(cpf, rg, nome, telefone, dataNascimento, endereco);
        setId(UUID.randomUUID().toString());
        setLogin(login);
        setSenha(senha);
        setNCTPS(nctps);
        setDataAdmissao(dataAdmissao);
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

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
}