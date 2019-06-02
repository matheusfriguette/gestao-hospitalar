import javax.swing.JFrame;

import views.LoginView;

public class App {
    public static void main(String[] args) throws Exception {
        LoginView login = new LoginView();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setSize(500, 500);
        login.setVisible(true);

    }
}