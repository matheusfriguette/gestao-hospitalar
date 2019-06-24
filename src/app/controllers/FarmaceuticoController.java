package app.controllers;

import java.io.IOException;
import java.util.HashMap;

import app.dao.FarmaceuticoDAO;
import app.dao.RemedioDAO;
import app.models.Farmaceutico;
import app.models.Remedio;

/*
 * GerenteController
 */
public class FarmaceuticoController {

    public FarmaceuticoController() {
    }

    public Farmaceutico getFarmaceuticoLogado() {
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();

        try {
            return farmaceuticoDAO.getFarmaceutico(LoginController.usuarioLogado);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public HashMap<String, Remedio> getRemedios() {
        RemedioDAO remedioDAO = new RemedioDAO();

        try {
            return remedioDAO.getRemedios();
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