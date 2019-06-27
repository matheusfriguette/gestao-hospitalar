package app.views;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import app.models.Hospital;
import app.models.Remedio;

public class FarmaceuticoMasterView extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private Hospital hospital;
    private DefaultTableModel tabelaRemedios;
    private String[] idsRemedios;

    public FarmaceuticoMasterView() {
        this.hospital = new Hospital();
        this.tabelaRemedios = new DefaultTableModel(new Object[0][4],
                new String[] { "ID", "Nome", "Qtd disponivel", "Preço" });
        initComponents();
        this.loadTabelas();
    }

    private void loadTabelas() {
        int index = 0;
        ArrayList<Remedio> remedios = hospital.getRemedios();
        Object[][] remediosData = new Object[remedios.size()][4];
        this.idsRemedios = new String[remedios.size()];
        for (Remedio remedio : remedios) {
            idsRemedios[index] = remedio.getId();
            remediosData[index][0] = remedio.getId().substring(0, remedio.getId().indexOf("-"));
            remediosData[index][1] = remedio.getNome();
            remediosData[index][2] = remedio.getQuantidadeDisponivel();
            remediosData[index][3] = "R$" + remedio.getPreco();
            index++;
        }
        this.tabelaRemedios = new DefaultTableModel(remediosData,
                new String[] { "ID", "Nome", "Qtd disponivel", "Preço" });

        jTable3.setModel(this.tabelaRemedios);
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema hospitalar");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setText("Bem vindo, " + this.hospital.getUsuarioLogado().getNome());

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Alterar senha");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240,
                                                Short.MAX_VALUE)
                                        .addComponent(jButton1))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanel3Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2)))
                        .addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup().addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1).addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton2)
                        .addContainerGap(25, Short.MAX_VALUE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel3, gridBagConstraints);

        jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel8.setToolTipText("");
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jTable3.setModel(this.tabelaRemedios);
        jScrollPane3.setViewportView(jTable3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 6.0;
        gridBagConstraints.weighty = 1.0;
        jPanel8.add(jScrollPane3, gridBagConstraints);

        jButton5.setText("Editar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Novo");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Deletar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup().addContainerGap(42, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(42, Short.MAX_VALUE)));
        jPanel9Layout
                .setVerticalGroup(
                        jPanel9Layout
                                .createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel9Layout.createSequentialGroup().addGap(50, 50, 50)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(152, Short.MAX_VALUE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel8.add(jPanel9, gridBagConstraints);

        jTabbedPane3.addTab("Remédios", null, jPanel8, "");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 10.0;
        getContentPane().add(jTabbedPane3, gridBagConstraints);

        pack();
    }

    /*
     * Botão sair
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        int option = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja sair?", "Sair?",
                JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }

    /*
     * Botão alterar senha
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        AlterarSenhaView alterarSenhaView = new AlterarSenhaView(hospital.getUsuarioLogado().getId());
        alterarSenhaView.pack();
        alterarSenhaView.setLocationRelativeTo(null);
        alterarSenhaView.setVisible(true);
    }

    /*
     * Botão novo remédio
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        InserirRemedioView inserirRemedioView = new InserirRemedioView();
        inserirRemedioView.pack();
        inserirRemedioView.setLocationRelativeTo(null);
        inserirRemedioView.setVisible(true);
        this.dispose();
    }

    /*
     * Botão editar remédio
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable3.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um remédio", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            Remedio remedio = hospital
                    .getRemedio(this.idsRemedios[jTable3.getSelectionModel().getAnchorSelectionIndex()]);
            InserirRemedioView inserirRemedioView = new InserirRemedioView(remedio);
            inserirRemedioView.pack();
            inserirRemedioView.setLocationRelativeTo(null);
            inserirRemedioView.setVisible(true);
            this.dispose();
        }
    }

    /*
     * Botão deletar remédio
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable3.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um remédio", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar este remédio?",
                    "Deletar remédio?", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                hospital.deleteRemedio(this.idsRemedios[jTable3.getSelectionModel().getAnchorSelectionIndex()]);
                this.loadTabelas();
            }
        }
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable3;
}
