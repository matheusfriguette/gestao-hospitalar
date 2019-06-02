package views;


import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * LoginView
 */
public class LoginView extends JFrame {
    public LoginView() {
        super("Login");
        this.InicializarTela();

    }

    private void InicializarTela() {
        add(new JLabel("Loga ae bro"));
    }
}