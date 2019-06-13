package app.models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import app.dao.MedicoDAO;

/*
 * Medico
 */
public class Medico extends Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    private static long serialUID;
    private String id;
    private String crm;
    private String especialidade;

    /*
     * Construtores
     */
    public Medico() {
        super(null, null, null, null, null, null, null, null, null, null);
        setId(Long.toString(++serialUID));
        setCRM(null);
        setEspecialidade(null);
    }

    public Medico(String crm, String especialidade, String login, String senha, String nctps, Date dataAdmissao,
            String cpf, String rg, String nome, String telefone, Date dataNascimento, Endereco endereco) {
        super(login, senha, nctps, dataAdmissao, cpf, rg, nome, telefone, dataNascimento, endereco);
        setId(Long.toString(++serialUID));
        setCRM(crm);
        setEspecialidade(especialidade);
    }

    static {
        MedicoDAO medico = new MedicoDAO();
        try {
            serialUID = medico.getLastKey();
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

    public String getCRM() {
        return crm;
    }

    public void setCRM(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}