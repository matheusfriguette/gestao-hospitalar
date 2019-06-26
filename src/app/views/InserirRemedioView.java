package app.views;

import javax.swing.JOptionPane;

import app.models.Hospital;
import app.models.Remedio;

public class InserirRemedioView extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private Hospital hospital;
    private String remedioId;

    public InserirRemedioView() {
        hospital = new Hospital();
        initComponents();
    }

    public InserirRemedioView(Remedio remedio) {
        hospital = new Hospital();
        this.remedioId = remedio.getId();
        initComponents();

        jTextField2.setText(remedio.getNome());
        jTextField3.setText(remedio.getObservacoes());
        jSpinner1.setValue(remedio.getQuantidadeDisponivel());
        jTextField5.setText(Double.toString(remedio.getPreco()));
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inserir remédio");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados básicos"));

        jLabel2.setText("Nome:");

        jLabel10.setText("Observações gerais:");

        jLabel3.setText("Quantidade disponível:");

        jLabel4.setText("Preço:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2))
                                .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 245,
                                                Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanel2Layout.createSequentialGroup().addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSpinner1))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanel2Layout.createSequentialGroup().addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField5)))
                        .addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10).addComponent(jTextField3,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 75,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
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
     * Botão enviar
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        Remedio remedio = new Remedio(jTextField2.getText(), jTextField3.getText(),
                Integer.parseInt(jSpinner1.getValue().toString()), Double.parseDouble(jTextField5.getText()));

        if (this.remedioId != null) {
            remedio.setId(this.remedioId);
            this.hospital.editRemedio(this.remedioId, remedio);

            JOptionPane.showMessageDialog(null, "Remédio editado com sucesso", "Sucesso!",
                    JOptionPane.INFORMATION_MESSAGE);
            FarmaceuticoMasterView farmaceuticoMasterView = new FarmaceuticoMasterView();
            farmaceuticoMasterView.pack();
            farmaceuticoMasterView.setLocationRelativeTo(null);
            farmaceuticoMasterView.setVisible(true);
            this.dispose();
        } else {
            this.hospital.addRemedio(remedio);

            JOptionPane.showMessageDialog(null, "Remédio inserido com sucesso", "Sucesso!",
                    JOptionPane.INFORMATION_MESSAGE);
            FarmaceuticoMasterView farmaceuticoMasterView = new FarmaceuticoMasterView();
            farmaceuticoMasterView.pack();
            farmaceuticoMasterView.setLocationRelativeTo(null);
            farmaceuticoMasterView.setVisible(true);
            this.dispose();
        }
    }

    /*
     * Botão cancelar
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        FarmaceuticoMasterView farmaceuticoMasterView = new FarmaceuticoMasterView();
        farmaceuticoMasterView.pack();
        farmaceuticoMasterView.setLocationRelativeTo(null);
        farmaceuticoMasterView.setVisible(true);
        this.dispose();
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
}
