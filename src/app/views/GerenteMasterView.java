package app.views;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.swing.JOptionPane;

import app.controllers.GerenteController;
import app.dao.FarmaceuticoDAO;
import app.dao.GerenteDAO;
import app.dao.MedicoDAO;
import app.dao.SecretarioDAO;
import app.models.Farmaceutico;
import app.models.Gerente;
import app.models.Medico;
import app.models.Secretario;

public class GerenteMasterView extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private GerenteDAO gerenteDAO;
    private SecretarioDAO secretarioDAO;
    private MedicoDAO medicoDAO;
    private FarmaceuticoDAO farmaceuticoDAO;
    private GerenteController gerenteController;
    private Gerente gerenteLogado;
    private HashMap<String, Gerente> listaGerentes;
    private HashMap<String, Secretario> listaSecretarios;
    private HashMap<String, Medico> listaMedicos;
    private HashMap<String, Farmaceutico> listaFarmaceuticos;
    private String[] listaIdGerentes;
    private String[] listaIdSecretarios;
    private String[] listaIdMedicos;
    private String[] listaIdFarmaceuticos;
    private Object[][] tabelaGerentes;
    private Object[][] tabelaSecretarios;
    private Object[][] tabelaMedicos;
    private Object[][] tabelaFarmaceuticos;

    public GerenteMasterView() {
        this.gerenteDAO = new GerenteDAO();
        this.secretarioDAO = new SecretarioDAO();
        this.medicoDAO = new MedicoDAO();
        this.farmaceuticoDAO = new FarmaceuticoDAO();
        this.gerenteController = new GerenteController();
        this.gerenteLogado = gerenteController.getGerenteLogado();
        this.loadTabelas();
        initComponents();
    }

    private void loadTabelas() {
        this.listaGerentes = gerenteController.getGerentes();
        this.listaSecretarios = gerenteController.getSecretarios();
        this.listaMedicos = gerenteController.getMedicos();
        this.listaFarmaceuticos = gerenteController.getFarmaceuticos();

        this.tabelaGerentes = new Object[listaGerentes.keySet().size()][4];
        this.listaIdGerentes = new String[listaGerentes.keySet().size()];
        int index = 0;
        for (String id : listaGerentes.keySet()) {
            Gerente gerente = listaGerentes.get(id);
            listaIdGerentes[index] = id;
            tabelaGerentes[index][0] = gerente.getNome();
            tabelaGerentes[index][1] = gerente.getTelefone();
            tabelaGerentes[index][2] = gerente.getDataAdmissao() != null
                    ? new SimpleDateFormat("dd/MM/yyyy").format(gerente.getDataAdmissao())
                    : "";
            tabelaGerentes[index][3] = gerente.getNCTPS();
            index++;
        }

        this.tabelaSecretarios = new Object[listaSecretarios.keySet().size()][5];
        this.listaIdSecretarios = new String[listaSecretarios.keySet().size()];
        index = 0;
        for (String id : listaSecretarios.keySet()) {
            Secretario secretario = listaSecretarios.get(id);
            listaIdSecretarios[index] = id;
            tabelaSecretarios[index][0] = secretario.getNome();
            tabelaSecretarios[index][1] = secretario.getTelefone();
            tabelaSecretarios[index][2] = secretario.getDataAdmissao() != null
                    ? new SimpleDateFormat("dd/MM/yyyy").format(secretario.getDataAdmissao())
                    : "";
            tabelaSecretarios[index][3] = secretario.getNCTPS();
            tabelaSecretarios[index][4] = secretario.getHorarioEntrada() != null && secretario.getHorarioSaida() != null
                    ? new SimpleDateFormat("hh:mm").format(secretario.getHorarioEntrada()) + " - "
                            + new SimpleDateFormat("hh:mm").format(secretario.getHorarioSaida())
                    : "";
            index++;
        }

        this.tabelaMedicos = new Object[listaMedicos.keySet().size()][5];
        this.listaIdMedicos = new String[listaMedicos.keySet().size()];
        index = 0;
        for (String id : listaMedicos.keySet()) {
            Medico medico = listaMedicos.get(id);
            listaIdMedicos[index] = id;
            tabelaMedicos[index][0] = medico.getNome();
            tabelaMedicos[index][1] = medico.getTelefone();
            tabelaMedicos[index][2] = medico.getDataAdmissao() != null
                    ? new SimpleDateFormat("dd/MM/yyyy").format(medico.getDataAdmissao())
                    : "";
            tabelaMedicos[index][3] = medico.getNCTPS();
            tabelaMedicos[index][4] = medico.getEspecialidade();
            index++;
        }

        this.tabelaFarmaceuticos = new Object[listaFarmaceuticos.keySet().size()][4];
        this.listaIdFarmaceuticos = new String[listaFarmaceuticos.keySet().size()];
        index = 0;
        for (String id : listaFarmaceuticos.keySet()) {
            Farmaceutico farmaceutico = listaFarmaceuticos.get(id);
            listaIdFarmaceuticos[index] = id;
            tabelaFarmaceuticos[index][0] = farmaceutico.getNome();
            tabelaFarmaceuticos[index][1] = farmaceutico.getTelefone();
            tabelaFarmaceuticos[index][2] = farmaceutico.getDataAdmissao() != null
                    ? new SimpleDateFormat("dd/MM/yyyy").format(farmaceutico.getDataAdmissao())
                    : "";
            tabelaFarmaceuticos[index][3] = farmaceutico.getNCTPS();
            index++;
        }
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

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema hospitalar");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setText("Bem vindo, " + this.gerenteLogado.getNome());

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(this.tabelaGerentes,
                new String[] { "Nome", "Telefone", "Data de admissão", "NCTPS" }) {
            Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
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

        jTable4.setModel(new javax.swing.table.DefaultTableModel(this.tabelaSecretarios,
                new String[] { "Nome", "Telefone", "Data de admissão", "NCTPS", "Horário" }) {
            Class[] types = new Class[] { java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
                    java.lang.Object.class, java.lang.String.class };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
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

        jTable5.setModel(new javax.swing.table.DefaultTableModel(this.tabelaMedicos,
                new String[] { "Nome", "Telefone", "Data de admissão", "NCTPS", "Especialidade" }));
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

        jTable6.setModel(new javax.swing.table.DefaultTableModel(this.tabelaFarmaceuticos,
                new String[] { "Nome", "Telefone", "Data de admissão", "NCTPS" }));
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
        AlterarSenhaView alterarSenhaView = new AlterarSenhaView("gerente", gerenteLogado.getId());
        alterarSenhaView.pack();
        alterarSenhaView.setLocationRelativeTo(null);
        alterarSenhaView.setVisible(true);
    }

    /*
     * Botão editar gerente
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable1.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um gerente", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Gerente gerente = gerenteDAO
                        .getGerente(this.listaIdGerentes[jTable1.getSelectionModel().getAnchorSelectionIndex()]);
                InserirGerenteView inserirGerenteView = new InserirGerenteView(gerente);
                inserirGerenteView.pack();
                inserirGerenteView.setLocationRelativeTo(null);
                inserirGerenteView.setVisible(true);
                this.dispose();
            } catch (ClassNotFoundException | IOException e) {
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /*
     * Botão editar secretário
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable4.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um secretário", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Secretario secretario = secretarioDAO
                        .getSecretario(this.listaIdSecretarios[jTable4.getSelectionModel().getAnchorSelectionIndex()]);
                InserirSecretarioView inserirSecretarioView = new InserirSecretarioView(secretario);
                inserirSecretarioView.pack();
                inserirSecretarioView.setLocationRelativeTo(null);
                inserirSecretarioView.setVisible(true);
                this.dispose();
            } catch (ClassNotFoundException | IOException e) {
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
            }
        }
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
     * Botão deletar gerente
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable1.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um gerente", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            if (this.listaIdGerentes[jTable1.getSelectionModel().getAnchorSelectionIndex()]
                    .equals(this.gerenteLogado.getId())) {
                JOptionPane.showMessageDialog(null, "Você não pode deletar seu próprio usuário", "Erro!",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                int option = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar este gerente?",
                        "Deletar gerente?", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    try {
                        gerenteDAO.deleteGerente(
                                this.listaIdGerentes[jTable1.getSelectionModel().getAnchorSelectionIndex()]);
                        this.loadTabelas();
                    } catch (ClassNotFoundException | IOException e) {
                        JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!",
                                JOptionPane.WARNING_MESSAGE);
                    }
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
     * Botão deletar secretário
     */
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable4.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um secretário", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar este secretário?",
                    "Deletar secretário?", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                try {
                    secretarioDAO.deleteSecretario(
                            this.listaIdSecretarios[jTable4.getSelectionModel().getAnchorSelectionIndex()]);
                    this.loadTabelas();
                } catch (ClassNotFoundException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    /*
     * Botão editar médico
     */
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable5.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um médico", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Medico medico = medicoDAO
                        .getMedico(this.listaIdMedicos[jTable5.getSelectionModel().getAnchorSelectionIndex()]);
                InserirMedicoView inserirMedicoView = new InserirMedicoView(medico);
                inserirMedicoView.pack();
                inserirMedicoView.setLocationRelativeTo(null);
                inserirMedicoView.setVisible(true);
                this.dispose();
            } catch (ClassNotFoundException | IOException e) {
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
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
     * Botão deletar médico
     */
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable5.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um médico", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar este médico?",
                    "Deletar médico?", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                try {
                    medicoDAO.deleteMedico(this.listaIdMedicos[jTable5.getSelectionModel().getAnchorSelectionIndex()]);
                    this.loadTabelas();
                } catch (ClassNotFoundException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    /*
     * Botão editar farmacêutico
     */
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable6.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um farmacêutico", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Farmaceutico farmaceutico = farmaceuticoDAO.getFarmaceutico(
                        this.listaIdFarmaceuticos[jTable6.getSelectionModel().getAnchorSelectionIndex()]);
                InserirFarmaceuticoView inserirFarmaceuticoView = new InserirFarmaceuticoView(farmaceutico);
                inserirFarmaceuticoView.pack();
                inserirFarmaceuticoView.setLocationRelativeTo(null);
                inserirFarmaceuticoView.setVisible(true);
                this.dispose();
            } catch (ClassNotFoundException | IOException e) {
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
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
     * Botão deletar farmacêutico
     */
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable6.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um farmacêutico", "Erro!", JOptionPane.WARNING_MESSAGE);
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar este farmacêutico?",
                    "Deletar farmacêutico?", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                try {
                    farmaceuticoDAO.deleteFarmaceutico(
                            this.listaIdFarmaceuticos[jTable6.getSelectionModel().getAnchorSelectionIndex()]);
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
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
}
