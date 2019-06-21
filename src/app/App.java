package app;

import java.util.HashMap;

import javax.swing.JFrame;

import app.dao.GerenteDAO;
import app.models.Gerente;
import app.views.LoginView;

public class App {
    public static void main(String[] args) throws Exception {
        Gerente gerente = new Gerente();
        Gerente gerente2 = new Gerente();
        GerenteDAO gerenteDAO = new GerenteDAO();
        gerenteDAO.addGerente(gerente);
        gerenteDAO.addGerente(gerente2);
        HashMap<String, Gerente> gerentes = gerenteDAO.getGerentes();
        // LoginView login = new LoginView();
        // login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // login.setSize(380, 200);
        // login.setVisible(true);
    }
}