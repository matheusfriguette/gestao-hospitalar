package app.models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import app.dao.ConsultaDAO;

/*
 * Consulta
 */
public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;
    private static long serialUID;
    private String id;
    private Paciente paciente;
    private Medico medico;
    private Date data;
    private Boolean consultaRealizada;
    private Diagnostico diagnostico;

    /*
     * Construtores
     */
    public Consulta() {
        setId(Long.toString(++serialUID));
        setPaciente(null);
        setMedico(null);
        setData(null);
        setConsultaRealizada(null);
        setDiagnostico(null);
    }

    public Consulta(Paciente paciente, Medico medico, Date data, Boolean consultaRealizada, Diagnostico diagnostico) {
        setId(Long.toString(++serialUID));
        setPaciente(paciente);
        setMedico(medico);
        setData(data);
        setConsultaRealizada(consultaRealizada);
        setDiagnostico(diagnostico);
    }

    static {
        ConsultaDAO consulta = new ConsultaDAO();
        try {
            serialUID = consulta.getLastKey();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public Boolean getConsultaRealizada() {
        return consultaRealizada;
    }

    public void setConsultaRealizada(Boolean consultaRealizada) {
        this.consultaRealizada = consultaRealizada;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
}