package app.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/*
 * Paciente
 */
public class Paciente extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private PlanoPaciente plano;
    public ArrayList<Consulta> consultas;

    /*
     * Construtores
     */
    public Paciente() {
        super(null, null, null, null, null, null);
        setId(UUID.randomUUID().toString());
        setPlano(null);
        setConsultas(null);
    }

    public Paciente(String cpf, String rg, String nome, String telefone, LocalDate dataNascimento, Endereco endereco,
            ArrayList<Consulta> consultas, PlanoPaciente plano) {
        super(cpf, rg, nome, telefone, dataNascimento, endereco);
        setId(UUID.randomUUID().toString());
        setPlano(plano);
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

    public PlanoPaciente getPlano() {
        return plano;
    }

    public void setPlano(PlanoPaciente plano) {
        this.plano = plano;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }

    /*
     * Métodos
     */
    public void addConsulta(Consulta consulta) {
        this.consultas.add(consulta);
        this.plano.diminuiConsultasRestantes();
    }

    public boolean podeConsultar() {
        if (plano == null) {
            return false;
        } else {
            return this.plano.getConsultasRestantes() > 0;
        }
    }
}