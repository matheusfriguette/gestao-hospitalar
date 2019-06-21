package app.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/*
 * Paciente
 */
public class Paciente extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    /*
     * Construtores
     */
    public Paciente() {
        super(null, null, null, null, null, null);
        setId(UUID.randomUUID().toString());
    }

    public Paciente(String cpf, String rg, String nome, String telefone, Date dataNascimento, Endereco endereco) {
        super(cpf, rg, nome, telefone, dataNascimento, endereco);
        setId(UUID.randomUUID().toString());
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