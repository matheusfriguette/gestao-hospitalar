package app.views;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import app.dao.ConsultaDAO;
import app.dao.ExameDAO;
import app.dao.MedicoDAO;
import app.dao.PacienteDAO;
import app.dao.RemedioDAO;
import app.models.Consulta;
import app.models.Exame;
import app.models.Remedio;

public class RealizarConsultaView extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private ConsultaDAO consultaDAO;
    private MedicoDAO medicoDAO;
    private PacienteDAO pacienteDAO;
    private ExameDAO exameDAO;
    private RemedioDAO remedioDAO;
    private HashMap<String, Exame> listaExames;
    private String[] opcoesExames;
    private String[] listaIdOpcoesExames;
    private String[] selecionadoExames;
    private String[] listaIdSelecionadoExames;
    private HashMap<String, Remedio> listaRemedios;
    private String[] opcoesRemedios;
    private String[] listaIdOpcoesRemedios;
    private String[] selecionadoRemedios;
    private String[] listaIdSelecionadoRemedios;

    public RealizarConsultaView(Consulta consulta) {
        consultaDAO = new ConsultaDAO();
        medicoDAO = new MedicoDAO();
        pacienteDAO = new PacienteDAO();
        exameDAO = new ExameDAO();
        remedioDAO = new RemedioDAO();
        initComponents();

        try {
            this.listaExames = exameDAO.getExames();
            this.listaRemedios = remedioDAO.getRemedios();
        } catch (ClassNotFoundException | IOException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
        }

        this.opcoesExames = new String[listaExames.keySet().size()];
        this.listaIdOpcoesExames = new String[listaExames.keySet().size()];
        DefaultListModel<String> listModelExames = new DefaultListModel<>();
        int index = 0;
        for (String id : listaExames.keySet()) {
            Exame exame = listaExames.get(id);
            listModelExames.addElement(exame.getNome());
            opcoesExames[index] = exame.getNome();
            listaIdOpcoesExames[index] = id;
            index++;
        }

        this.opcoesRemedios = new String[listaRemedios.keySet().size()];
        this.listaIdOpcoesRemedios = new String[listaRemedios.keySet().size()];
        DefaultListModel<String> listModelRemedios = new DefaultListModel<>();
        index = 0;
        for (String id : listaRemedios.keySet()) {
            Remedio remedio = listaRemedios.get(id);
            listModelRemedios.addElement(remedio.getNome());
            opcoesRemedios[index] = remedio.getNome();
            listaIdOpcoesRemedios[index] = id;
            index++;
        }

        jList1.setModel(listModelExames);
        jList3.setModel(listModelRemedios);
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Realizar consulta");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados básicos"));

        jLabel1.setText("Sintomas:");

        jLabel2.setText("Observações:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))
                        .addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Exames"));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "" };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "" };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane2.setViewportView(jList2);

        jLabel3.setText("Opções");

        jLabel4.setText("Selecionados");

        jButton3.setText("Adicionar");

        jButton4.setText("Excluir");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel4).addGap(0, 0,
                                Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel3).addGap(0, 0,
                                        Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                        .createSequentialGroup()
                                        .addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 271,
                                                        Short.MAX_VALUE)
                                                .addComponent(jScrollPane1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButton3).addComponent(jButton4,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap()))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanel2Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanel2Layout
                                                .createSequentialGroup().addComponent(jButton3).addGap(45, 45, 45)))
                        .addComponent(jLabel4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(
                                        jPanel2Layout.createSequentialGroup().addGap(38, 38, 38).addComponent(jButton4))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap()));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 4.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Remédios"));

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "" };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane3.setViewportView(jList3);

        jList4.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "" };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane4.setViewportView(jList4);

        jLabel5.setText("Opções");

        jLabel6.setText("Selecionados");

        jButton5.setText("Adicionar");

        jButton6.setText("Excluir");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel6).addGap(0, 0,
                                Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel5).addGap(0, 0,
                                        Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout
                                        .createSequentialGroup()
                                        .addGroup(jPanel4Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 271,
                                                        Short.MAX_VALUE)
                                                .addComponent(jScrollPane3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel4Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButton5).addComponent(jButton6,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap()))));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanel4Layout.createSequentialGroup()
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanel4Layout
                                                .createSequentialGroup().addComponent(jButton5).addGap(45, 45, 45)))
                        .addComponent(jLabel6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(
                                        jPanel4Layout.createSequentialGroup().addGap(38, 38, 38).addComponent(jButton6))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap()));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 4.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jPanel4, gridBagConstraints);

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
                        jPanel3Layout.createSequentialGroup().addContainerGap(274, Short.MAX_VALUE)
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

    }

    /*
     * Botão cancelar
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        MedicoMasterView medicoMasterView = new MedicoMasterView();
        medicoMasterView.pack();
        medicoMasterView.setLocationRelativeTo(null);
        medicoMasterView.setVisible(true);
        this.dispose();
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
}
