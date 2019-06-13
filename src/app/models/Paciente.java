package app.models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import app.dao.PacienteDAO;

/*
 * Paciente
 */
public class Paciente extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private static long serialUID = 1L;
    private String id;

    /*
     * Construtores
     */
    public Paciente() {
        super(null, null, null, null, null, null);
        setId(Long.toString(++serialUID));
    }

    public Paciente(String cpf, String rg, String nome, String telefone, Date dataNascimento, Endereco endereco) {
        super(cpf, rg, nome, telefone, dataNascimento, endereco);
        setId(Long.toString(++serialUID));
    }

    static {
        PacienteDAO paciente = new PacienteDAO();
        try {
            serialUID = paciente.getLastKey();
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