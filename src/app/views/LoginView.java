package app.views;

import javax.swing.JOptionPane;

import app.controllers.LoginController;
import app.models.Gerente;
import app.models.Medico;
import app.models.Secretario;
import app.models.Farmaceutico;

public class LoginView extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    public LoginView() {
        initComponents();
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema hospitalar");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite seus dados de login"));

        jLabel6.setText("Login:");

        jLabel10.setText("Senha:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Selecione", "Farmacêutico(a)", "Gerente", "Médico(a)", "Secretário(a)" }));

        jLabel7.setText("Cargo:");

        jButton1.setText("Logar");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1))
                                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
                                        .addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel6).addComponent(jLabel10).addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                                .addComponent(jTextField2).addComponent(jPasswordField1,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))))
                        .addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7).addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18).addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }

    /*
     * Botão logar
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        LoginController loginController = new LoginController();
        char aux[] = jPasswordField1.getPassword();
        String login = jTextField2.getText();
        String senha = new String(aux);

        if (jComboBox1.getSelectedItem().toString() == "Médico(a)") {
            Medico medico = loginController.logarMedico(login, senha);

            if (medico != null) {
                this.dispose();
                MedicoMasterView medicoMasterView = new MedicoMasterView();
                medicoMasterView.pack();
                medicoMasterView.setLocationRelativeTo(null);
                medicoMasterView.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "O login ou senha informados estão incorretos", "Erro!",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else if (jComboBox1.getSelectedItem().toString() == "Secretário(a)") {
            Secretario secretario = loginController.logarSecretario(login, senha);

            if (secretario != null) {
                this.dispose();
                SecretarioMasterView secretarioMasterView = new SecretarioMasterView();
                secretarioMasterView.pack();
                secretarioMasterView.setLocationRelativeTo(null);
                secretarioMasterView.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "O login ou senha informados estão incorretos", "Erro!",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else if (jComboBox1.getSelectedItem().toString() == "Gerente") {
            Gerente gerente = loginController.logarGerente(login, senha);

            if (gerente != null) {
                GerenteMasterView gerenteMasterView = new GerenteMasterView();
                gerenteMasterView.pack();
                gerenteMasterView.setLocationRelativeTo(null);
                gerenteMasterView.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "O login ou senha informados estão incorretos", "Erro!",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else if (jComboBox1.getSelectedItem().toString() == "Farmacêutico(a)") {
            Farmaceutico farmaceutico = loginController.logarFarmaceutico(login, senha);

            if (farmaceutico != null) {
                FarmaceuticoMasterView farmaceuticoMasterView = new FarmaceuticoMasterView();
                farmaceuticoMasterView.pack();
                farmaceuticoMasterView.setLocationRelativeTo(null);
                farmaceuticoMasterView.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "O login ou senha informados estão incorretos", "Erro!",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField2;
}
