package app;

import java.util.ArrayList;

import javax.swing.JFrame;

import app.dao.GerenteDAO;
import app.models.Gerente;
import app.views.LoginView;

public class App {
    public static void main(String[] args) throws Exception {
        // Gerente gerente = new Gerente("matheus", "password", "NCTPS", "12/02/2001", "CPF", "RG", "nome", "TELEFONE",
        //         "14/02/2001");
        // GerenteDAO gerenteDAO = new GerenteDAO();
        // gerenteDAO.addUsuario(gerente);
        // ArrayList<Gerente> gerentes = gerenteDAO.getGerentes();
        LoginView login = new LoginView();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setSize(380, 200);
        login.setVisible(true);
    }
}