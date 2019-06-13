package app.models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import app.dao.SecretarioDAO;

/*
 * Secretaria
 */
public class Secretario extends Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    private static long serialUID = 1L;
    private String id;
    private Date horarioEntrada;
    private Date horarioSaida;

    /*
     * Construtores
     */
    public Secretario() {
        super(null, null, null, null, null, null, null, null, null, null);
        setId(Long.toString(++serialUID));
        setHorarioEntrada(null);
        setHorarioSaida(null);
    }

    public Secretario(Date horarioEntrada, Date horarioSaida, String login, String senha, String nctps,
            Date dataAdmissao, String cpf, String rg, String nome, String telefone, Date dataNascimento,
            Endereco endereco) {
        super(login, senha, nctps, dataAdmissao, cpf, rg, nome, telefone, dataNascimento, endereco);
        setId(Long.toString(++serialUID));
        setHorarioEntrada(horarioEntrada);
        setHorarioSaida(horarioSaida);
    }

    static {
        SecretarioDAO secretario = new SecretarioDAO();
        try {
            serialUID = secretario.getLastKey();
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

    public Date getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(Date horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public Date getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(Date horarioSaida) {
        this.horarioSaida = horarioSaida;
    }
}