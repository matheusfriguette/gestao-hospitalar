package app.views;

import java.io.IOException;
import javax.swing.JOptionPane;

import app.dao.FarmaceuticoDAO;
import app.dao.GerenteDAO;
import app.dao.MedicoDAO;
import app.dao.SecretarioDAO;
import app.models.*;

public class AlterarSenhaView extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private String tipoFuncionario;
    private String funcionarioId;

    public AlterarSenhaView(String tipoFuncionario, String funcionarioId) {
        this.tipoFuncionario = tipoFuncionario;
        this.funcionarioId = funcionarioId;
        initComponents();
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alterar senha");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Alterar senha"));

        jLabel2.setText("Nova senha:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                        .addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jPanel2, gridBagConstraints);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        jPanel3Layout.createSequentialGroup().addContainerGap(262, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1).addComponent(jButton2))
                                .addContainerGap()));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel3, gridBagConstraints);

        pack();
    }

    /*
     * Botão Ok
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        char aux[] = jPasswordField1.getPassword();
        String senha = new String(aux);

        if (senha == "" || senha == null) {
            JOptionPane.showMessageDialog(null, "O campo senha é obrigatório", "Atenção!", JOptionPane.WARNING_MESSAGE);
        } else {
            if (tipoFuncionario == "gerente") {
                GerenteDAO gerenteDAO = new GerenteDAO();
                Gerente gerente = new Gerente();

                try {
                    gerente = gerenteDAO.getGerente(funcionarioId);
                } catch (ClassNotFoundException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
                }

                gerente.setSenha(senha);

                try {
                    gerenteDAO.editGerente(funcionarioId, gerente);
                } catch (ClassNotFoundException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
                }

                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!", "Sucesso!",
                        JOptionPane.WARNING_MESSAGE);
                this.dispose();
            } else if (tipoFuncionario == "secretario") {
                SecretarioDAO secretarioDAO = new SecretarioDAO();
                Secretario secretario = new Secretario();

                try {
                    secretario = secretarioDAO.getSecretario(funcionarioId);
                } catch (ClassNotFoundException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
                }

                secretario.setSenha(senha);

                try {
                    secretarioDAO.editSecretario(funcionarioId, secretario);
                } catch (ClassNotFoundException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
                }

                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!", "Sucesso!",
                        JOptionPane.WARNING_MESSAGE);
                this.dispose();
            } else if (tipoFuncionario == "medico") {
                MedicoDAO medicoDAO = new MedicoDAO();
                Medico medico = new Medico();

                try {
                    medico = medicoDAO.getMedico(funcionarioId);
                } catch (ClassNotFoundException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
                }

                medico.setSenha(senha);

                try {
                    medicoDAO.editMedico(funcionarioId, medico);
                } catch (ClassNotFoundException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
                }

                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!", "Sucesso!",
                        JOptionPane.WARNING_MESSAGE);
                this.dispose();
            } else if (tipoFuncionario == "farmaceutico") {
                FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();
                Farmaceutico farmaceutico = new Farmaceutico();

                try {
                    farmaceutico = farmaceuticoDAO.getFarmaceutico(funcionarioId);
                } catch (ClassNotFoundException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
                }

                farmaceutico.setSenha(senha);

                try {
                    farmaceuticoDAO.editFarmaceutico(funcionarioId, farmaceutico);
                } catch (ClassNotFoundException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
                }

                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!", "Sucesso!",
                        JOptionPane.WARNING_MESSAGE);
                this.dispose();
            }
        }
    }

    /*
     * Botão cancelar
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
}
