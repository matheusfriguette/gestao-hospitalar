package app.views;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import app.models.Consulta;
import app.models.Hospital;

public class MedicoMasterView extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private Hospital hospital;
    private DefaultTableModel tabelaConsultas;
    private String[] idsConsultas;

    public MedicoMasterView() {
        this.hospital = new Hospital();
        this.tabelaConsultas = new DefaultTableModel(new Object[0][4], new String[] { "ID", "Paciente", "Data" });
        initComponents();
        this.loadTabelas();
    }

    private void loadTabelas() {
        int index = 0;
        ArrayList<Consulta> consultas = hospital.getConsultas();
        Object[][] consultasData = new Object[consultas.size()][3];
        this.idsConsultas = new String[consultas.size()];
        for (Consulta consulta : consultas) {
            if (!consulta.getConsultaRealizada()) {
                idsConsultas[index] = consulta.getId();
                consultasData[index][0] = consulta.getId().substring(0, consulta.getId().indexOf("-"));
                consultasData[index][1] = consulta.getPaciente() != null ? consulta.getPaciente().getNome() : "";
                consultasData[index][2] = consulta.getData() != null
                        ? consulta.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
                        : "";
                index++;
            }
        }
        this.tabelaConsultas = new DefaultTableModel(consultasData, new String[] { "ID", "Paciente", "Data" });

        jTable8.setModel(this.tabelaConsultas);
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74,
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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel3, gridBagConstraints);

        jPanel18.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel18.setLayout(new java.awt.GridBagLayout());

        jTable8.setModel(tabelaConsultas);
        jScrollPane8.setViewportView(jTable8);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 6.0;
        gridBagConstraints.weighty = 1.0;
        jPanel18.add(jScrollPane8, gridBagConstraints);

        jButton15.setText("Consultar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout
                        .createSequentialGroup().addContainerGap(27, Short.MAX_VALUE).addComponent(jButton15,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE)));
        jPanel19Layout.setVerticalGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout
                        .createSequentialGroup().addGap(50, 50, 50).addComponent(jButton15,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(185, Short.MAX_VALUE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel18.add(jPanel19, gridBagConstraints);

        jTabbedPane7.addTab("Consultas", jPanel18);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 10.0;
        getContentPane().add(jTabbedPane7, gridBagConstraints);

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
     * Botão consultar
     */
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable8.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um paciente", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            Consulta consulta = hospital
                    .getConsulta(this.idsConsultas[jTable8.getSelectionModel().getAnchorSelectionIndex()]);
            RealizarConsultaView realizarConsultaView = new RealizarConsultaView(consulta);
            realizarConsultaView.pack();
            realizarConsultaView.setLocationRelativeTo(null);
            realizarConsultaView.setVisible(true);
            this.dispose();
        }
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTable jTable8;
}
