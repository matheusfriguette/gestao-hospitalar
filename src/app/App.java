package app;

import app.views.LoginView;

public class App {
    public static void main(String[] args) throws Exception {
        LoginView loginView = new LoginView();
        loginView.pack();
        loginView.setLocationRelativeTo(null);
        loginView.setVisible(true);
    }
}