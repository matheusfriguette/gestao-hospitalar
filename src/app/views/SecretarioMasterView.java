package app.views;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.swing.JOptionPane;

import app.controllers.SecretarioController;
import app.models.Secretario;
import app.dao.ConsultaDAO;
import app.dao.ExameDAO;
import app.dao.PacienteDAO;
import app.views.RemarcarConsultaView;
import app.views.HistoricoPacienteView;
import app.models.Paciente;
import app.models.Consulta;
import app.models.Exame;

public class SecretarioMasterView extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private PacienteDAO pacienteDAO;
    private ConsultaDAO consultaDAO;
    private ExameDAO exameDAO;
    private Secretario secretarioLogado;
    private SecretarioController secretarioController;
    private HashMap<String, Paciente> listaPacientes;
    private HashMap<String, Consulta> listaConsultas;
    private HashMap<String, Exame> listaExames;
    private String[] listaIdPacientes;
    private String[] listaIdConsultas;
    private String[] listaIdExames;
    private Object[][] tabelaPacientes;
    private Object[][] tabelaConsultas;
    private Object[][] tabelaExames;

    public SecretarioMasterView() {
        this.pacienteDAO = new PacienteDAO();
        this.consultaDAO = new ConsultaDAO();
        this.exameDAO = new ExameDAO();
        this.secretarioController = new SecretarioController();
        this.secretarioLogado = secretarioController.getSecretarioLogado();
        initComponents();
        this.loadTabelas();
    }

    private void loadTabelas() {
        this.listaPacientes = secretarioController.getPacientes();
        this.listaConsultas = secretarioController.getConsultas();
        this.listaExames = secretarioController.getExames();

        this.tabelaPacientes = new Object[listaPacientes.keySet().size()][4];
        this.listaIdPacientes = new String[listaPacientes.keySet().size()];
        int index = 0;
        for (String id : listaPacientes.keySet()) {
            Paciente paciente = listaPacientes.get(id);
            listaIdPacientes[index] = id;
            tabelaPacientes[index][0] = paciente.getNome();
            tabelaPacientes[index][1] = paciente.getCPF();
            tabelaPacientes[index][2] = paciente.getTelefone();
            tabelaPacientes[index][3] = paciente.getConsultas() != null && paciente.getConsultas().size() > 0
                    ? (paciente.getConsultas().get(0).getData() != null
                            ? new SimpleDateFormat("dd/MM/yyyy hh:mm").format(paciente.getConsultas().get(0).getData())
                            : "Nenhuma consulta marcada")
                    : "Nenhuma consulta marcada";
            index++;
        }

        this.tabelaConsultas = new Object[listaConsultas.keySet().size()][4];
        this.listaIdConsultas = new String[listaConsultas.keySet().size()];
        index = 0;
        for (String id : listaConsultas.keySet()) {
            Consulta consulta = listaConsultas.get(id);
            listaIdConsultas[index] = id;
            tabelaConsultas[index][0] = consulta.getId().substring(0, consulta.getId().indexOf("-"));
            tabelaConsultas[index][1] = consulta.getPaciente() != null ? consulta.getPaciente().getNome() : "";
            tabelaConsultas[index][2] = consulta.getMedico() != null ? consulta.getMedico().getNome() : "";
            tabelaConsultas[index][3] = consulta.getData() != null
                    ? new SimpleDateFormat("dd/MM/yyyy").format(consulta.getData())
                    : "";
            index++;
        }

        this.tabelaExames = new Object[listaExames.keySet().size()][5];
        this.listaIdExames = new String[listaExames.keySet().size()];
        index = 0;
        for (String id : listaExames.keySet()) {
            Exame exame = listaExames.get(id);
            listaIdExames[index] = id;
            tabelaExames[index][0] = exame.getId().substring(0, exame.getId().indexOf("-"));
            tabelaExames[index][1] = exame.getNome();
            tabelaExames[index][2] = exame.getObservacoes();
            tabelaExames[index][3] = exame.getTempoDuracao() != null ? exame.getTempoDuracao().toString() : "";
            index++;
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(this.tabelaPacientes,
                new String[] { "Nome", "CPF", "Telefone", "Primeira consulta" }));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(this.tabelaConsultas,
                new String[] { "ID", "Paciente", "Médico", "Data" }));
        jTable5.setModel(new javax.swing.table.DefaultTableModel(this.tabelaExames,
                new String[] { "ID", "Nome", "Observações", "Duração" }));
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema hospitalar");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(this.tabelaPacientes,
                new String[] { "Nome", "CPF", "Telefone", "Primeira consulta" }));
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 6.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jScrollPane1, gridBagConstraints);

        jButton3.setText("Ver histórico");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Marcar consulta");
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

        jButton12.setText("Editar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Deletar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup().addContainerGap(49, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(40, Short.MAX_VALUE)));
        jPanel5Layout
                .setVerticalGroup(
                        jPanel5Layout
                                .createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup().addGap(50, 50, 50)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(107, Short.MAX_VALUE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jPanel5, gridBagConstraints);

        jTabbedPane1.addTab("Pacientes", jPanel4);

        jPanel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(this.tabelaConsultas,
                new String[] { "ID", "Paciente", "Médico", "Data" }));
        jScrollPane4.setViewportView(jTable4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 6.0;
        gridBagConstraints.weighty = 1.0;
        jPanel10.add(jScrollPane4, gridBagConstraints);

        jButton4.setText("Remarcar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setText("Desmarcar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup().addContainerGap(45, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(45, Short.MAX_VALUE)));
        jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup().addGap(50, 50, 50)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18).addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(251, Short.MAX_VALUE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel10.add(jPanel11, gridBagConstraints);

        jTabbedPane1.addTab("Consultas", jPanel10);

        jPanel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel12.setLayout(new java.awt.GridBagLayout());

        jTable5.setModel(new javax.swing.table.DefaultTableModel(this.tabelaExames,
                new String[] { "ID", "Nome", "Observações", "Duração" }));
        jScrollPane5.setViewportView(jTable5);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 6.0;
        gridBagConstraints.weighty = 1.0;
        jPanel12.add(jScrollPane5, gridBagConstraints);

        jButton9.setText("Editar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Novo");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Deletar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup().addContainerGap(45, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(45, Short.MAX_VALUE)));
        jPanel13Layout
                .setVerticalGroup(
                        jPanel13Layout
                                .createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel13Layout.createSequentialGroup().addGap(50, 50, 50)
                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(203, Short.MAX_VALUE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel12.add(jPanel13, gridBagConstraints);

        jTabbedPane1.addTab("Exames", jPanel12);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 10.0;
        getContentPane().add(jTabbedPane1, gridBagConstraints);
        jTabbedPane1.getAccessibleContext().setAccessibleName("Pacientes");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setText("Bem vindo, " + this.secretarioLogado.getNome());

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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 311,
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
                        .addContainerGap(20, Short.MAX_VALUE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel3, gridBagConstraints);

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
        AlterarSenhaView alterarSenhaView = new AlterarSenhaView("secretario", secretarioLogado.getId());
        alterarSenhaView.pack();
        alterarSenhaView.setLocationRelativeTo(null);
        alterarSenhaView.setVisible(true);
    }

    /*
     * Botão marcar consulta
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable1.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um paciente", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Paciente paciente = pacienteDAO
                        .getPaciente(this.listaIdPacientes[jTable1.getSelectionModel().getAnchorSelectionIndex()]);
                InserirConsultaView inserirConsultaView = new InserirConsultaView(paciente);
                inserirConsultaView.pack();
                inserirConsultaView.setLocationRelativeTo(null);
                inserirConsultaView.setVisible(true);
                this.dispose();
            } catch (ClassNotFoundException | IOException e) {
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /*
     * Botão ver histórico
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable1.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um paciente", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Paciente paciente = pacienteDAO
                        .getPaciente(this.listaIdPacientes[jTable1.getSelectionModel().getAnchorSelectionIndex()]);
                HistoricoPacienteView historicoPacienteView = new HistoricoPacienteView(paciente);
                historicoPacienteView.pack();
                historicoPacienteView.setLocationRelativeTo(null);
                historicoPacienteView.setVisible(true);
            } catch (ClassNotFoundException | IOException e) {
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /*
     * Botão novo paciente
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        InserirPacienteView inserirPacienteView = new InserirPacienteView();
        inserirPacienteView.pack();
        inserirPacienteView.setLocationRelativeTo(null);
        inserirPacienteView.setVisible(true);
        this.dispose();
    }

    /*
     * Botão editar paciente
     */
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable1.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um paciente", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Paciente paciente = pacienteDAO
                        .getPaciente(this.listaIdPacientes[jTable1.getSelectionModel().getAnchorSelectionIndex()]);
                InserirPacienteView inserirPacienteView = new InserirPacienteView(paciente);
                inserirPacienteView.pack();
                inserirPacienteView.setLocationRelativeTo(null);
                inserirPacienteView.setVisible(true);
                this.dispose();
            } catch (ClassNotFoundException | IOException e) {
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /*
     * Botão deletar paciente
     */
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable1.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um paciente", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar este paciente?",
                    "Deletar paciente?", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                try {
                    pacienteDAO.deletePaciente(
                            this.listaIdPacientes[jTable1.getSelectionModel().getAnchorSelectionIndex()]);
                    this.loadTabelas();
                } catch (ClassNotFoundException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
                }

            }
        }
    }

    /*
     * Botão desmarcar
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable4.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione uma consulta", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja desmarcar esta consulta?",
                    "Desmarcar consulta?", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                try {
                    consultaDAO.deleteConsulta(
                            this.listaIdConsultas[jTable4.getSelectionModel().getAnchorSelectionIndex()]);
                    this.loadTabelas();
                } catch (ClassNotFoundException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
                }

            }
        }
    }

    /*
     * Botão remarcar
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable4.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione uma consulta", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Consulta consulta = consultaDAO
                        .getConsulta(this.listaIdConsultas[jTable4.getSelectionModel().getAnchorSelectionIndex()]);
                RemarcarConsultaView remarcarConsultaView = new RemarcarConsultaView(consulta);
                remarcarConsultaView.pack();
                remarcarConsultaView.setLocationRelativeTo(null);
                remarcarConsultaView.setVisible(true);
                this.dispose();
            } catch (ClassNotFoundException | IOException e) {
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /*
     * Botão novo exame
     */
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
        InserirExameView inserirExameView = new InserirExameView();
        inserirExameView.pack();
        inserirExameView.setLocationRelativeTo(null);
        inserirExameView.setVisible(true);
        this.dispose();
    }

    /*
     * Botão editar exame
     */
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable5.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um exame", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Exame exame = exameDAO
                        .getExame(this.listaIdExames[jTable5.getSelectionModel().getAnchorSelectionIndex()]);
                InserirExameView inserirExameView = new InserirExameView(exame);
                inserirExameView.pack();
                inserirExameView.setLocationRelativeTo(null);
                inserirExameView.setVisible(true);
                this.dispose();
            } catch (ClassNotFoundException | IOException e) {
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /*
     * Botão deletar exame
     */
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable5.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um exame", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar este exame?",
                    "Deletar exame?", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                try {
                    exameDAO.deleteExame(this.listaIdExames[jTable5.getSelectionModel().getAnchorSelectionIndex()]);
                    this.loadTabelas();
                } catch (ClassNotFoundException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
                }

            }
        }
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
}
