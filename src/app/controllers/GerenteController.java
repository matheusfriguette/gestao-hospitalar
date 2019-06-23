package app.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import app.dao.FarmaceuticoDAO;
import app.dao.GerenteDAO;
import app.dao.MedicoDAO;
import app.dao.SecretarioDAO;
import app.models.Farmaceutico;
import app.models.Gerente;
import app.models.Medico;
import app.models.Secretario;

/*
 * GerenteController
 */
public class GerenteController {

    public GerenteController() {
    }

    public Gerente getGerenteLogado() {
        GerenteDAO gerenteDAO = new GerenteDAO();

        try {
            return gerenteDAO.getGerente(LoginController.usuarioLogado);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public HashMap<String, Gerente> getGerentes() {
        GerenteDAO gerenteDAO = new GerenteDAO();

        try {
            return gerenteDAO.getGerentes();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public HashMap<String, Secretario> getSecretarios() {
        SecretarioDAO secretarioDAO = new SecretarioDAO();

        try {
            return secretarioDAO.getSecretarios();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public HashMap<String, Medico> getMedicos() {
        MedicoDAO medicoDAO = new MedicoDAO();

        try {
            return medicoDAO.getMedicos();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public HashMap<String, Farmaceutico> getFarmaceuticos() {
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();

        try {
            return farmaceuticoDAO.getFarmaceuticos();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}