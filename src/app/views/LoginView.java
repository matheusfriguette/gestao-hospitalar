package app.views;

import app.controllers.LoginController;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import java.io.IOException;

/*
 * LoginView
 */
public class LoginView extends JFrame {
    private LoginController loginController;

    private JPanel panelLogin;
    private JLabel lblDigite;
    private JLabel lblLogin;
    private JLabel lblSenha;
    private JLabel lblTipoFuncionarios;
    private JPasswordField pswSenha;
    private JButton btnLogin;
    private JTextField txtLogin;
    private JComboBox cmbTipoFuncionarios;
    private String tipoFuncionarios[] = { "Secretário(a)", "Médico(a)", "Gerente" };

    /*
     * Construtores
     */
    public LoginView() throws IOException {
        super("Login");
        InicializarTela();
        loginController = new LoginController();
    }

    private void InicializarTela() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));
        setResizable(false);

        panelLogin = new JPanel();
        panelLogin.setBackground(new java.awt.Color(255, 255, 255));
        panelLogin.setRequestFocusEnabled(false);
        panelLogin.setVerifyInputWhenFocusTarget(false);

        lblDigite = new JLabel("Digite seus dados de Login");
        lblDigite.setHorizontalAlignment(0);

        lblLogin = new JLabel("Login:");
        lblLogin.setHorizontalAlignment(4);

        txtLogin = new JTextField(20);

        lblSenha = new JLabel("Senha:");
        lblSenha.setHorizontalAlignment(4);

        pswSenha = new JPasswordField(20);

        lblTipoFuncionarios = new JLabel("Cargo:");

        btnLogin = new JButton("Logar");

        cmbTipoFuncionarios = new JComboBox(tipoFuncionarios);
        cmbTipoFuncionarios.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(panelLoginLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addContainerGap(37, Short.MAX_VALUE)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnLogin)
                                .addGroup(panelLoginLayout.createSequentialGroup().addGroup(
                                        panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lblLogin, -2, 72, -2).addComponent(lblSenha)
                                                .addComponent(lblTipoFuncionarios))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelLoginLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lblDigite)
                                                .addComponent(pswSenha, -1, 171, Short.MAX_VALUE).addComponent(txtLogin)
                                                .addGroup(panelLoginLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(cmbTipoFuncionarios)))))
                        .addGap(64, 64, 64)));

        panelLoginLayout.setVerticalGroup(panelLoginLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addContainerGap(48, Short.MAX_VALUE).addComponent(lblDigite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblLogin).addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pswSenha, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblSenha))
                        .addGap(10, 10, 10)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(lblTipoFuncionarios).addComponent(cmbTipoFuncionarios).addGap(30, 30, 30))
                        .addComponent(btnLogin).addGap(18, 18, 18)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 362, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                                panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 172, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                                panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)));

        pack();
        setLocationRelativeTo(null);
    }

    private void btnLogarAction(java.awt.event.ActionEvent evento) {
        if ((String)cmbTipoFuncionarios.getSelectedItem() == tipoFuncionarios[0]) {
            logarSecretario();
        }
        else if((String)cmbTipoFcun)
    }

    private void logarSecretario() {
        String login = txtLogin.getText();
        String senha = pswSenha.getPassword().toString();

        Secretario secretario = this.loginController.logarSecretario(login, senha);

        if (secretario != null) {
            // logou
        } else {
            JOptionPane.showMessageDialog(null, "O login ou senha informados estão incorretos", "Erro!",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

}