package app.views;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import app.models.Farmaceutico;
import app.models.Gerente;
import app.models.Hospital;
import app.models.Medico;
import app.models.Plano;
import app.models.Secretario;

public class GerenteMasterView extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private Hospital hospital;
    private DefaultTableModel tabelaGerentes;
    private DefaultTableModel tabelaSecretarios;
    private DefaultTableModel tabelaMedicos;
    private DefaultTableModel tabelaFarmaceuticos;
    private DefaultTableModel tabelaPlanos;
    private String[] idsGerentes;
    private String[] idsSecretarios;
    private String[] idsMedicos;
    private String[] idsFarmaceuticos;
    private String[] idsPlanos;

    public GerenteMasterView() {
        this.hospital = new Hospital();
        this.tabelaGerentes = new DefaultTableModel(new Object[0][4],
                new String[] { "Nome", "Telefone", "Data de admissão", "NCTPS" });
        this.tabelaSecretarios = new DefaultTableModel(new Object[0][5],
                new String[] { "Nome", "Telefone", "Data de admissão", "NCTPS", "Horário" });
        this.tabelaMedicos = new DefaultTableModel(new Object[0][5],
                new String[] { "Nome", "Telefone", "Data de admissão", "NCTPS", "Especialidade" });
        this.tabelaFarmaceuticos = new DefaultTableModel(new Object[0][4],
                new String[] { "Nome", "Telefone", "Data de admissão", "NCTPS" });
        this.tabelaPlanos = new DefaultTableModel(new Object[0][4],
                new String[] { "Nome", "Valor", "Consultas", "Faixa etária" });
        initComponents();
        this.loadTabelas();
    }

    private void loadTabelas() {
        int index = 0;
        ArrayList<Gerente> gerentes = hospital.getGerentes();
        Object[][] gerentesData = new Object[gerentes.size()][4];
        this.idsGerentes = new String[gerentes.size()];
        for (Gerente gerente : gerentes) {
            idsGerentes[index] = gerente.getId();
            gerentesData[index][0] = gerente.getNome();
            gerentesData[index][1] = gerente.getTelefone();
            gerentesData[index][2] = gerente.getDataAdmissao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            gerentesData[index][3] = gerente.getNCTPS();
            index++;
        }
        this.tabelaGerentes = new DefaultTableModel(gerentesData,
                new String[] { "Nome", "Telefone", "Data de admissão", "NCTPS" });

        index = 0;
        ArrayList<Secretario> secretarios = hospital.getSecretarios();
        Object[][] secretariosData = new Object[secretarios.size()][5];
        this.idsSecretarios = new String[secretarios.size()];
        for (Secretario secretario : secretarios) {
            idsSecretarios[index] = secretario.getId();
            secretariosData[index][0] = secretario.getNome();
            secretariosData[index][1] = secretario.getTelefone();
            secretariosData[index][2] = secretario.getDataAdmissao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            secretariosData[index][3] = secretario.getNCTPS();
            secretariosData[index][4] = secretario.getHorarioEntrada().format(DateTimeFormatter.ofPattern("HH:mm"))
                    + " - " + secretario.getHorarioSaida().format(DateTimeFormatter.ofPattern("HH:mm"));
            index++;
        }
        this.tabelaSecretarios = new DefaultTableModel(secretariosData,
                new String[] { "Nome", "Telefone", "Data de admissão", "NCTPS", "Horário" });

        index = 0;
        ArrayList<Medico> medicos = hospital.getMedicos();
        Object[][] medicosData = new Object[medicos.size()][5];
        this.idsMedicos = new String[medicos.size()];
        for (Medico medico : medicos) {
            idsMedicos[index] = medico.getId();
            medicosData[index][0] = medico.getNome();
            medicosData[index][1] = medico.getTelefone();
            medicosData[index][2] = medico.getDataAdmissao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            medicosData[index][3] = medico.getNCTPS();
            medicosData[index][4] = medico.getEspecialidade();
        }
        this.tabelaMedicos = new DefaultTableModel(medicosData,
                new String[] { "Nome", "Telefone", "Data de admissão", "NCTPS", "Especialidade" });

        index = 0;
        ArrayList<Farmaceutico> farmaceuticos = hospital.getFarmaceuticos();
        Object[][] farmaceuticosData = new Object[farmaceuticos.size()][4];
        this.idsFarmaceuticos = new String[farmaceuticos.size()];
        for (Farmaceutico farmaceutico : farmaceuticos) {
            idsFarmaceuticos[index] = farmaceutico.getId();
            farmaceuticosData[index][0] = farmaceutico.getNome();
            farmaceuticosData[index][1] = farmaceutico.getTelefone();
            farmaceuticosData[index][2] = farmaceutico.getDataAdmissao()
                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            farmaceuticosData[index][3] = farmaceutico.getNCTPS();
            index++;
        }
        this.tabelaFarmaceuticos = new DefaultTableModel(farmaceuticosData,
                new String[] { "Nome", "Telefone", "Data de admissão", "NCTPS" });

        index = 0;
        ArrayList<Plano> planos = hospital.getPlanos();
        Object[][] planosData = new Object[planos.size()][4];
        this.idsPlanos = new String[planos.size()];
        for (Plano plano : planos) {
            idsPlanos[index] = plano.getId();
            planosData[index][0] = plano.getNome();
            planosData[index][1] = "R$ " + plano.getValor();
            planosData[index][2] = plano.getConsultasDisponiveis();
            planosData[index][3] = plano.getIdadeMinima() + " - " + plano.getIdadeMaxima();
            index++;
        }
        this.tabelaPlanos = new DefaultTableModel(planosData,
                new String[] { "Nome", "Valor", "Consultas", "Faixa etária" });

        jTable1.setModel(this.tabelaGerentes);
        jTable4.setModel(this.tabelaSecretarios);
        jTable5.setModel(this.tabelaMedicos);
        jTable6.setModel(this.tabelaFarmaceuticos);
        jTable7.setModel(this.tabelaPlanos);
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema hospitalar");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setText("Bem vindo, " + hospital.getUsuarioLogado().getNome());

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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332,
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
        jPanel3.getAccessibleContext().setAccessibleName("");
        jPanel3.getAccessibleContext().setAccessibleDescription("");

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jTable1.setModel(tabelaGerentes);
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

        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Novo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Deletar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup().addContainerGap(43, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(44, Short.MAX_VALUE)));
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
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jPanel5, gridBagConstraints);

        jTabbedPane1.addTab("Gerentes", jPanel4);

        jPanel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jTable4.setModel(tabelaSecretarios);
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

        jButton4.setText("Editar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setText("Novo");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Deletar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup().addContainerGap(43, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(44, Short.MAX_VALUE)));
        jPanel11Layout
                .setVerticalGroup(
                        jPanel11Layout
                                .createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel11Layout.createSequentialGroup().addGap(50, 50, 50)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel10.add(jPanel11, gridBagConstraints);

        jTabbedPane1.addTab("Secretários", jPanel10);

        jPanel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel12.setLayout(new java.awt.GridBagLayout());

        jTable5.setModel(tabelaMedicos);
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
                .addGroup(jPanel13Layout.createSequentialGroup().addContainerGap(43, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(44, Short.MAX_VALUE)));
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
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel12.add(jPanel13, gridBagConstraints);

        jTabbedPane1.addTab("Médicos", jPanel12);

        jPanel14.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel14.setLayout(new java.awt.GridBagLayout());

        jTable6.setModel(tabelaFarmaceuticos);
        jScrollPane6.setViewportView(jTable6);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 6.0;
        gridBagConstraints.weighty = 1.0;
        jPanel14.add(jScrollPane6, gridBagConstraints);

        jButton12.setText("Editar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Novo");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Deletar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup().addContainerGap(43, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(44, Short.MAX_VALUE)));
        jPanel15Layout
                .setVerticalGroup(
                        jPanel15Layout
                                .createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel15Layout.createSequentialGroup().addGap(50, 50, 50)
                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel14.add(jPanel15, gridBagConstraints);

        jTabbedPane1.addTab("Farmacêuticos", jPanel14);

        jPanel16.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel16.setLayout(new java.awt.GridBagLayout());

        jTable7.setModel(tabelaPlanos);
        jScrollPane7.setViewportView(jTable7);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 6.0;
        gridBagConstraints.weighty = 1.0;
        jPanel16.add(jScrollPane7, gridBagConstraints);

        jButton15.setText("Editar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Novo");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("Deletar");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup().addContainerGap(43, Short.MAX_VALUE)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(44, Short.MAX_VALUE)));
        jPanel17Layout
                .setVerticalGroup(
                        jPanel17Layout
                                .createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel17Layout.createSequentialGroup().addGap(50, 50, 50)
                                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel16.add(jPanel17, gridBagConstraints);

        jTabbedPane1.addTab("Planos", jPanel16);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 10.0;
        getContentPane().add(jTabbedPane1, gridBagConstraints);

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
     * Botão novo gerente
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        InserirGerenteView inserirGerenteView = new InserirGerenteView();
        inserirGerenteView.pack();
        inserirGerenteView.setLocationRelativeTo(null);
        inserirGerenteView.setVisible(true);
        this.dispose();
    }

    /*
     * Botão editar gerente
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable1.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um gerente", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            Gerente gerente = (Gerente) hospital
                    .getFuncionario(this.idsGerentes[jTable1.getSelectionModel().getAnchorSelectionIndex()]);
            InserirGerenteView inserirGerenteView = new InserirGerenteView(gerente);
            inserirGerenteView.pack();
            inserirGerenteView.setLocationRelativeTo(null);
            inserirGerenteView.setVisible(true);
            this.dispose();
        }
    }

    /*
     * Botão deletar gerente
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable1.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um gerente", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            if (this.idsGerentes[jTable1.getSelectionModel().getAnchorSelectionIndex()]
                    .equals(this.hospital.getUsuarioLogado().getId())) {
                JOptionPane.showMessageDialog(null, "Você não pode deletar seu próprio usuário", "Erro!",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                int option = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar este gerente?",
                        "Deletar gerente?", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    hospital.deleteFuncionario(this.idsGerentes[jTable1.getSelectionModel().getAnchorSelectionIndex()]);
                    this.loadTabelas();
                }
            }
        }
    }

    /*
     * Botão novo secretário
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        InserirSecretarioView inserirSecretarioView = new InserirSecretarioView();
        inserirSecretarioView.pack();
        inserirSecretarioView.setLocationRelativeTo(null);
        inserirSecretarioView.setVisible(true);
        this.dispose();
    }

    /*
     * Botão editar secretário
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable4.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um secretário", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            Secretario secretario = (Secretario) hospital
                    .getFuncionario(this.idsSecretarios[jTable4.getSelectionModel().getAnchorSelectionIndex()]);
            InserirSecretarioView inserirSecretarioView = new InserirSecretarioView(secretario);
            inserirSecretarioView.pack();
            inserirSecretarioView.setLocationRelativeTo(null);
            inserirSecretarioView.setVisible(true);
            this.dispose();
        }
    }

    /*
     * Botão deletar secretário
     */
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable4.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um secretário", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar este secretário?",
                    "Deletar secretário?", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                hospital.deleteFuncionario(this.idsSecretarios[jTable4.getSelectionModel().getAnchorSelectionIndex()]);
                this.loadTabelas();
            }
        }
    }

    /*
     * Botão novo médico
     */
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
        InserirMedicoView inserirMedicoView = new InserirMedicoView();
        inserirMedicoView.pack();
        inserirMedicoView.setLocationRelativeTo(null);
        inserirMedicoView.setVisible(true);
        this.dispose();
    }

    /*
     * Botão editar médico
     */
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable5.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um médico", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            Medico medico = (Medico) hospital
                    .getFuncionario(this.idsMedicos[jTable5.getSelectionModel().getAnchorSelectionIndex()]);
            InserirMedicoView inserirMedicoView = new InserirMedicoView(medico);
            inserirMedicoView.pack();
            inserirMedicoView.setLocationRelativeTo(null);
            inserirMedicoView.setVisible(true);
            this.dispose();
        }
    }

    /*
     * Botão deletar médico
     */
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable5.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um médico", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar este médico?",
                    "Deletar médico?", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                hospital.deleteFuncionario(this.idsMedicos[jTable5.getSelectionModel().getAnchorSelectionIndex()]);
                this.loadTabelas();
            }
        }
    }

    /*
     * Botão novo farmacêutico
     */
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {
        InserirFarmaceuticoView inserirFarmaceuticoView = new InserirFarmaceuticoView();
        inserirFarmaceuticoView.pack();
        inserirFarmaceuticoView.setLocationRelativeTo(null);
        inserirFarmaceuticoView.setVisible(true);
        this.dispose();
    }

    /*
     * Botão editar farmacêutico
     */
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable6.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um farmacêutico", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            Farmaceutico farmaceutico = (Farmaceutico) hospital
                    .getFuncionario(this.idsFarmaceuticos[jTable6.getSelectionModel().getAnchorSelectionIndex()]);
            InserirFarmaceuticoView inserirFarmaceuticoView = new InserirFarmaceuticoView(farmaceutico);
            inserirFarmaceuticoView.pack();
            inserirFarmaceuticoView.setLocationRelativeTo(null);
            inserirFarmaceuticoView.setVisible(true);
            this.dispose();
        }
    }

    /*
     * Botão deletar farmacêutico
     */
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable6.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um farmacêutico", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar este farmacêutico?",
                    "Deletar farmacêutico?", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                hospital.deleteFuncionario(
                        this.idsFarmaceuticos[jTable6.getSelectionModel().getAnchorSelectionIndex()]);
                this.loadTabelas();
            }
        }
    }

    /*
     * Botão novo plano
     */
    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {
        InserirPlanoView inserirPlanoView = new InserirPlanoView();
        inserirPlanoView.pack();
        inserirPlanoView.setLocationRelativeTo(null);
        inserirPlanoView.setVisible(true);
        this.dispose();
    }

    /*
     * Botão editar plano
     */
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        if (jTable7.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um plano", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            Plano plano = hospital.getPlano(this.idsPlanos[jTable7.getSelectionModel().getAnchorSelectionIndex()]);
            InserirPlanoView inserirPlanoView = new InserirPlanoView(plano);
            inserirPlanoView.pack();
            inserirPlanoView.setLocationRelativeTo(null);
            inserirPlanoView.setVisible(true);
            this.dispose();
        }
    }

    /*
     * Botão deletar plano
     */
    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable7.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um plano", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar este plano?",
                    "Deletar plano?", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                hospital.deletePlano(this.idsPlanos[jTable7.getSelectionModel().getAnchorSelectionIndex()]);
                this.loadTabelas();
            }
        }
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
}
