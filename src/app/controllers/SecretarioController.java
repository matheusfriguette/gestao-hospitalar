package app.controllers;

import java.io.IOException;
import java.util.HashMap;

import app.dao.ConsultaDAO;
import app.dao.ExameDAO;
import app.dao.PacienteDAO;
import app.dao.SecretarioDAO;
import app.models.Consulta;
import app.models.Exame;
import app.models.Paciente;
import app.models.Secretario;

/*
 * GerenteController
 */
public class SecretarioController {

    public SecretarioController() {
    }

    public Secretario getSecretarioLogado() {
        SecretarioDAO secretarioDAO = new SecretarioDAO();

        try {
            return secretarioDAO.getSecretario(LoginController.usuarioLogado);
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