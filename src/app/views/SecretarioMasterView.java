package app.views;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import app.views.RemarcarConsultaView;
import app.views.HistoricoPacienteView;
import app.models.Paciente;
import app.models.Consulta;
import app.models.Exame;
import app.models.Hospital;

public class SecretarioMasterView extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private Hospital hospital;
    private DefaultTableModel tabelaPacientes;
    private DefaultTableModel tabelaConsultas;
    private DefaultTableModel tabelaExames;
    private String[] idsPacientes;
    private String[] idsConsultas;
    private String[] idsExames;

    public SecretarioMasterView() {
        this.hospital = new Hospital();
        this.loadTabelas();
        initComponents();
    }

    private void loadTabelas() {
        int index = 0;
        ArrayList<Paciente> pacientes = hospital.getPacientes();
        Object[][] pacientesData = new Object[pacientes.size()][4];
        this.idsPacientes = new String[pacientes.size()];
        for (Paciente paciente : pacientes) {
            idsPacientes[index] = paciente.getId();
            pacientesData[index][0] = paciente.getNome();
            pacientesData[index][1] = paciente.getCPF();
            pacientesData[index][2] = paciente.getTelefone();
            pacientesData[index][3] = paciente.getConsultas() != null && paciente.getConsultas().size() > 0
                    ? (paciente.getConsultas().get(0).getData() != null ? paciente.getConsultas().get(0).getData()
                            .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) : "Nenhuma consulta marcada")
                    : "Nenhuma consulta marcada";
            index++;
        }
        this.tabelaPacientes = new DefaultTableModel(pacientesData,
                new String[] { "Nome", "CPF", "Telefone", "Primeira consulta" });

        index = 0;
        ArrayList<Consulta> consultas = hospital.getConsultas();
        Object[][] consultasData = new Object[consultas.size()][4];
        this.idsConsultas = new String[consultas.size()];
        for (Consulta consulta : consultas) {
            idsConsultas[index] = consulta.getId();
            consultasData[index][0] = consulta.getId().substring(0, consulta.getId().indexOf("-"));
            consultasData[index][1] = consulta.getPaciente() != null ? consulta.getPaciente().getNome() : "";
            consultasData[index][2] = consulta.getMedico() != null ? consulta.getMedico().getNome() : "";
            consultasData[index][3] = consulta.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            index++;
        }
        this.tabelaConsultas = new DefaultTableModel(consultasData,
                new String[] { "ID", "Paciente", "Médico", "Data" });

        index = 0;
        ArrayList<Exame> exames = hospital.getExames();
        Object[][] examesData = new Object[exames.size()][4];
        this.idsExames = new String[exames.size()];
        for (Exame exame : exames) {
            idsExames[index] = exame.getId();
            examesData[index][0] = exame.getId().substring(0, exame.getId().indexOf("-"));
            examesData[index][1] = exame.getNome();
            examesData[index][2] = exame.getObservacoes();
            examesData[index][3] = exame.getTempoResultado() / 86400 + " dias";
            index++;
        }
        this.tabelaExames = new DefaultTableModel(examesData, new String[] { "ID", "Nome", "Observações", "Duração" });
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
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema hospitalar");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jTable1.setModel(this.tabelaPacientes);
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

        jButton8.setText("Atribuir plano");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
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
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE))
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
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
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
                                        .addContainerGap(59, Short.MAX_VALUE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jPanel5, gridBagConstraints);

        jTabbedPane1.addTab("Pacientes", jPanel4);

        jPanel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jTable4.setModel(this.tabelaConsultas);
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

        jTable5.setModel(this.tabelaExames);
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
        AlterarSenhaView alterarSenhaView = new AlterarSenhaView(hospital.getUsuarioLogado().getId());
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
            Paciente paciente = hospital
                    .getPaciente(this.idsPacientes[jTable1.getSelectionModel().getAnchorSelectionIndex()]);
            if (paciente.podeConsultar()) {
                InserirConsultaView inserirConsultaView = new InserirConsultaView(paciente);
                inserirConsultaView.pack();
                inserirConsultaView.setLocationRelativeTo(null);
                inserirConsultaView.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "As consultas do paciente expiraram", "Erro!",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /*
     * Botão atribuir plano
     */
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable1.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um paciente", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            Paciente paciente = hospital
                    .getPaciente(this.idsPacientes[jTable1.getSelectionModel().getAnchorSelectionIndex()]);
            AtribuirPlanoView atribuirPlanoView = new AtribuirPlanoView(paciente);
            atribuirPlanoView.pack();
            atribuirPlanoView.setLocationRelativeTo(null);
            atribuirPlanoView.setVisible(true);
            this.dispose();
        }
    }

    /*
     * Botão ver histórico
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable1.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um paciente", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            Paciente paciente = hospital
                    .getPaciente(this.idsPacientes[jTable1.getSelectionModel().getAnchorSelectionIndex()]);
            HistoricoPacienteView historicoPacienteView = new HistoricoPacienteView(paciente);
            historicoPacienteView.pack();
            historicoPacienteView.setLocationRelativeTo(null);
            historicoPacienteView.setVisible(true);
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
            Paciente paciente = hospital
                    .getPaciente(this.idsPacientes[jTable1.getSelectionModel().getAnchorSelectionIndex()]);
            InserirPacienteView inserirPacienteView = new InserirPacienteView(paciente);
            inserirPacienteView.pack();
            inserirPacienteView.setLocationRelativeTo(null);
            inserirPacienteView.setVisible(true);
            this.dispose();
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
                hospital.deletePaciente(this.idsPacientes[jTable1.getSelectionModel().getAnchorSelectionIndex()]);
                this.loadTabelas();
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
                Consulta consulta = hospital.getConsulta(this.idsConsultas[jTable4.getSelectionModel().getAnchorSelectionIndex()]);
                Paciente paciente = consulta.getPaciente();
                paciente.deleteConsulta(consulta.getId());
                hospital.editPaciente(paciente.getId(), paciente);
                hospital.deleteConsulta(consulta.getId());
                this.loadTabelas();
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
            Consulta consulta = hospital
                    .getConsulta(this.idsConsultas[jTable4.getSelectionModel().getAnchorSelectionIndex()]);
            RemarcarConsultaView remarcarConsultaView = new RemarcarConsultaView(consulta);
            remarcarConsultaView.pack();
            remarcarConsultaView.setLocationRelativeTo(null);
            remarcarConsultaView.setVisible(true);
            this.dispose();
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
            Exame exame = hospital.getExame(this.idsExames[jTable5.getSelectionModel().getAnchorSelectionIndex()]);
            InserirExameView inserirExameView = new InserirExameView(exame);
            inserirExameView.pack();
            inserirExameView.setLocationRelativeTo(null);
            inserirExameView.setVisible(true);
            this.dispose();
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
                hospital.deleteExame(this.idsExames[jTable5.getSelectionModel().getAnchorSelectionIndex()]);
                this.loadTabelas();
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
    private javax.swing.JButton jButton8;
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
