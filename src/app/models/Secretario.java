package models;

import java.text.ParseException;
import java.util.Date;

/*
 * Secretaria
 */
public class Secretario extends Funcionario {
    private Date HorarioEntrada;
    private Date HorarioSaida;

    /*
     * Construtores
     */
    public Secretario() {
        super(null, null, null, null, null, null, null, null, null);
        setHorarioEntrada(null);
        setHorarioSaida(null);
    }

    public Secretario(String horarioEntrada, String horarioSaida, String login, String senha, String NCTPS,
            String dataAdmissao, String CPF, String RG, String nome, String telefone, String dataNascimento) {
        super(login, senha, NCTPS, dataAdmissao, CPF, RG, nome, telefone, dataNascimento);
        setHorarioEntrada(horarioEntrada);
        setHorarioSaida(horarioSaida);
    }

    /*
     * Gets and sets
     */
    public Date getHorarioEntrada() {
        return HorarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada) {
        try {
            this.HorarioEntrada = formatoHora.parse(horarioEntrada);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getHorarioSaida() {
        return HorarioSaida;
    }

    public void setHorarioSaida(String horarioSaida) {
        try {
            this.HorarioSaida = formatoHora.parse(horarioSaida);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}