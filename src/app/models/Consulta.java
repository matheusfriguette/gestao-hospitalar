package app.models;

import java.io.Serializable;
import java.util.Date;

/*
 * Consulta
 */
public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;
    private static long serialUID = 1L;
    private String id;
    private Paciente paciente;
    private Medico medico;
    private Date data;
    private Diagnostico diagnostico;

    /*
     * Construtores
     */
    public Consulta() {
        setId(Long.toString(serialUID++));
        setPaciente(null);
        setMedico(null);
        setData(null);
        setDiagnostico(null);
    }

    public Consulta(Paciente paciente, Medico medico, Date data, Diagnostico diagnostico) {
        setId(Long.toString(serialUID++));
        setPaciente(paciente);
        setMedico(medico);
        setData(data);
        setDiagnostico(diagnostico);
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
}