package app.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/*
 * Consulta
 */
public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime data;
    private boolean consultaRealizada;
    private Prontuario prontuario;

    /*
     * Construtores
     */
    public Consulta() {
        setId(UUID.randomUUID().toString());
        setPaciente(null);
        setMedico(null);
        setData(null);
        setConsultaRealizada(false);
        setProntuario(null);
    }

    public Consulta(Paciente paciente, Medico medico, LocalDateTime data, boolean consultaRealizada,
            Prontuario prontuario) {
        setId(UUID.randomUUID().toString());
        setPaciente(paciente);
        setMedico(medico);
        setData(data);
        setConsultaRealizada(consultaRealizada);
        setProntuario(prontuario);
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

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public boolean getConsultaRealizada() {
        return consultaRealizada;
    }

    public void setConsultaRealizada(boolean consultaRealizada) {
        this.consultaRealizada = consultaRealizada;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }
}