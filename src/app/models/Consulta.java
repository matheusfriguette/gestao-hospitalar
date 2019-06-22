package app.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/*
 * Consulta
 */
public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private Paciente paciente;
    private Medico medico;
    private Date data;
    private boolean consultaRealizada;
    private Diagnostico diagnostico;

    /*
     * Construtores
     */
    public Consulta() {
        setId(UUID.randomUUID().toString());
        setPaciente(null);
        setMedico(null);
        setData(null);
        setConsultaRealizada(false);
        setDiagnostico(null);
    }

    public Consulta(Paciente paciente, Medico medico, Date data, boolean consultaRealizada, Diagnostico diagnostico) {
        setId(UUID.randomUUID().toString());
        setPaciente(paciente);
        setMedico(medico);
        setData(data);
        setConsultaRealizada(consultaRealizada);
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

    public boolean getConsultaRealizada() {
        return consultaRealizada;
    }

    public void setConsultaRealizada(boolean consultaRealizada) {
        this.consultaRealizada = consultaRealizada;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
}