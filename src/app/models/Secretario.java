package app.models;

import java.text.ParseException;
import java.util.Date;

/*
 * Secretaria
 */
public class Secretario extends Funcionario {
    private Date horarioEntrada;
    private Date horarioSaida;

    /*
     * Construtores
     */
    public Secretario() {
        super(null, null, null, null, null, null, null, null, null);
        setHorarioEntrada(null);
        setHorarioSaida(null);
    }

    public Secretario(String horarioEntrada, String horarioSaida, String login, String senha, String nctps,
            String dataAdmissao, String cpf, String rg, String nome, String telefone, String dataNascimento) {
        super(login, senha, nctps, dataAdmissao, cpf, rg, nome, telefone, dataNascimento);
        setHorarioEntrada(horarioEntrada);
        setHorarioSaida(horarioSaida);
    }

    /*
     * Gets e sets
     */
    public Date getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada) {
        try {
            this.horarioEntrada = formatoHora.parse(horarioEntrada);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(String horarioSaida) {
        try {
            this.horarioSaida = formatoHora.parse(horarioSaida);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}