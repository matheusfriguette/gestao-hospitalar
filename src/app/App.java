package app;

import app.dao.GerenteDAO;
import app.models.Gerente;
import app.views.LoginView;

public class App {
    public static void main(String[] args) throws Exception {
        // Gerente gerente = new Gerente("matheus", "password", null, null, null, null,
        // "Matheus", null, null, null);
        // GerenteDAO gerenteDAO = new GerenteDAO();
        // gerenteDAO.addGerente(gerente);
        // gerenteDAO.getGerentes();
        new LoginView().setVisible(true);
    }
}