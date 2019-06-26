package app.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/*
 * Secretaria
 */
public class Secretario extends Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    private LocalTime horarioEntrada;
    private LocalTime horarioSaida;

    /*
     * Construtores
     */
    public Secretario() {
        super(null, null, null, null, null, null, null, null, null, null);
        setHorarioEntrada(null);
        setHorarioSaida(null);
    }

    public Secretario(LocalTime horarioEntrada, LocalTime horarioSaida, String login, String senha, String nctps,
            LocalDate dataAdmissao, String cpf, String rg, String nome, String telefone, LocalDate dataNascimento,
            Endereco endereco) {
        super(login, senha, nctps, dataAdmissao, cpf, rg, nome, telefone, dataNascimento, endereco);
        setHorarioEntrada(horarioEntrada);
        setHorarioSaida(horarioSaida);
    }

    /*
     * Gets e sets
     */
    public LocalTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(LocalTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public LocalTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }
}