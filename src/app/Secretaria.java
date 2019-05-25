package app;

import java.sql.Date;

/**
 * Secretaria
 */
public class Secretaria extends Funcionario {
    private Date HorarioEntrada;
    private Date HorarioSaida;

    public Secretaria(){
        super();
        setHorarioEntrada(null);
        setHorarioSaida(null);
    }

    public Secretaria(String CPF, String RG, String Nome, String Telefone, String DataNascimento, String Login, String Senha, String NCTPS, String DataAdmissao, String HorarioEntrada, String HorarioSaida){
        super(CPF, RG, Nome, Telefone, DataNascimento, Login, Senha, NCTPS, DataAdmissao);
        setHorarioEntrada(horarioEntrada);
        setHorarioSaida(horarioSaida);

    }

    public Date getHorarioEntrada() {
        return HorarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada) {
        this.HorarioEntrada = patternHoras.parse(horarioEntrada);
    }

    public Date getHorarioSaida() {
        return HorarioSaida;
    }

    public void setHorarioSaida(String horarioSaida) {
        this.HorarioSaida = patternHoras.parse(horarioSaida);
    }


}