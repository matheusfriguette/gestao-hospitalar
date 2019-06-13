package app.models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import app.dao.GerenteDAO;

/*
 * Gerente
 */
public class Gerente extends Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    private static long serialUID;
    private String id;

    /*
     * Construtores
     */
    public Gerente() {
        super(null, null, null, null, null, null, null, null, null, null);
        setId(Long.toString(++serialUID));
    }

    public Gerente(String login, String senha, String nctps, Date dataAdmissao, String cpf, String rg, String nome,
            String telefone, Date dataNascimento, Endereco endereco) {
        super(login, senha, nctps, dataAdmissao, cpf, rg, nome, telefone, dataNascimento, endereco);
        setId(Long.toString(++serialUID));
    }

    static {
        GerenteDAO gerente = new GerenteDAO();
        try {
            serialUID = gerente.getLastKey();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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