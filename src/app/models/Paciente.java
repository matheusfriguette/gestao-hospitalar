package app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/*
 * Paciente
 */
public class Paciente extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    public ArrayList<Consulta> consultas;

    /*
     * Construtores
     */
    public Paciente() {
        super(null, null, null, null, null, null);
        setId(UUID.randomUUID().toString());
        setConsultas(null);
    }

    public Paciente(String cpf, String rg, String nome, String telefone, Date dataNascimento, Endereco endereco, ArrayList<Consulta> consultas) {
        super(cpf, rg, nome, telefone, dataNascimento, endereco);
        setId(UUID.randomUUID().toString());
        setConsultas(consultas);
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

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }
}