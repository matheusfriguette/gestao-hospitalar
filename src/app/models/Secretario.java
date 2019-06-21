package app.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/*
 * Secretaria
 */
public class Secretario extends Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private Date horarioEntrada;
    private Date horarioSaida;

    /*
     * Construtores
     */
    public Secretario() {
        super(null, null, null, null, null, null, null, null, null, null);
        setId(UUID.randomUUID().toString());
        setHorarioEntrada(null);
        setHorarioSaida(null);
    }

    public Secretario(Date horarioEntrada, Date horarioSaida, String login, String senha, String nctps,
            Date dataAdmissao, String cpf, String rg, String nome, String telefone, Date dataNascimento,
            Endereco endereco) {
        super(login, senha, nctps, dataAdmissao, cpf, rg, nome, telefone, dataNascimento, endereco);
        setId(UUID.randomUUID().toString());
        setHorarioEntrada(horarioEntrada);
        setHorarioSaida(horarioSaida);
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