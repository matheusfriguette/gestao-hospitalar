package app.views;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.swing.JOptionPane;

import app.controllers.MedicoController;
import app.models.Medico;
import app.dao.ConsultaDAO;
import app.models.Consulta;

public class MedicoMasterView extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private ConsultaDAO consultaDAO;
    private Medico medicoLogado;
    private MedicoController medicoController;
    private HashMap<String, Consulta> listaConsultas;
    private String[] listaIdConsultas;
    private Object[][] tabelaConsultas;

    public MedicoMasterView() {
        this.consultaDAO = new ConsultaDAO();
        this.medicoController = new MedicoController();
        this.medicoLogado = medicoController.getMedicoLogado();
        initComponents();
        this.loadTabelas();
    }

    private void loadTabelas() {
        this.listaConsultas = medicoController.getConsultas();

        this.tabelaConsultas = new Object[listaConsultas.keySet().size()][4];
        this.listaIdConsultas = new String[listaConsultas.keySet().size()];
        int index = 0;
        for (String id : listaConsultas.keySet()) {
            Consulta consulta = listaConsultas.get(id);
            if (!consulta.getConsultaRealizada()) {
                listaIdConsultas[index] = id;
                tabelaConsultas[index][0] = consulta.getId().substring(0, consulta.getId().indexOf("-"));
                tabelaConsultas[index][1] = consulta.getPaciente() != null ? consulta.getPaciente().getNome() : "";
                tabelaConsultas[index][2] = consulta.getData() != null
                        ? new SimpleDateFormat("dd/MM/yyyy hh:mm").format(consulta.getData())
                        : "";
                index++;
            }
        }

        jTable8.setModel(new javax.swing.table.DefaultTableModel(this.tabelaConsultas,
                new String[] { "ID", "Paciente", "Data" }));
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
        jLabel1.setText("Bem vindo, " + this.medicoLogado.getNome());

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

        jTable8.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

        }, new String[] { "ID", "Paciente", "Data" }));
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
        AlterarSenhaView alterarSenhaView = new AlterarSenhaView("medico", medicoLogado.getId());
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
            try {
                Consulta consulta = consultaDAO
                        .getConsulta(this.listaIdConsultas[jTable8.getSelectionModel().getAnchorSelectionIndex()]);
                RealizarConsultaView realizarConsultaView = new RealizarConsultaView(consulta);
                realizarConsultaView.pack();
                realizarConsultaView.setLocationRelativeTo(null);
                realizarConsultaView.setVisible(true);
                this.dispose();
            } catch (ClassNotFoundException | IOException e) {
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
            }
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
