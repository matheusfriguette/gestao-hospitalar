package app.controllers;

import java.io.IOException;
import java.util.HashMap;

import app.dao.ConsultaDAO;
import app.dao.ExameDAO;
import app.dao.PacienteDAO;
import app.dao.MedicoDAO;
import app.models.Consulta;
import app.models.Exame;
import app.models.Paciente;
import app.models.Medico;

/*
 * GerenteController
 */
public class MedicoController {

    public MedicoController() {
    }

    public Medico getMedicoLogado() {
        MedicoDAO medicoDAO = new MedicoDAO();

        try {
            return medicoDAO.getMedico(LoginController.usuarioLogado);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public HashMap<String, Paciente> getPacientes() {
        PacienteDAO pacienteDAO = new PacienteDAO();

        try {
            return pacienteDAO.getPacientes();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public HashMap<String, Consulta> getConsultas() {
        ConsultaDAO consultaDAO = new ConsultaDAO();

        try {
            return consultaDAO.getConsultas();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public HashMap<String, Exame> getExames() {
        ExameDAO exameDAO = new ExameDAO();

        try {
            return exameDAO.getExames();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}