package app;

import java.time.LocalDate;

import app.models.Gerente;
import app.models.Hospital;
import app.views.LoginView;

public class App {
    public static void main(String[] args) throws Exception {
        Gerente gerente = new Gerente("matheus", "password", "dsadasd", LocalDate.now(), null, null, "Matheus", null, LocalDate.now(), null);
        Hospital hospital = new Hospital();
        hospital.addFuncionario(gerente);
        LoginView loginView = new LoginView();
        loginView.pack();
        loginView.setLocationRelativeTo(null);
        loginView.setVisible(true);
    }
}