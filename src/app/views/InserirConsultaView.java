package app.views;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javax.swing.JOptionPane;

import app.dao.ConsultaDAO;
import app.dao.MedicoDAO;
import app.dao.PacienteDAO;
import app.models.Consulta;
import app.models.Medico;
import app.models.Paciente;

public class InserirConsultaView extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private ConsultaDAO consultaDAO;
    private MedicoDAO medicoDAO;
    private PacienteDAO pacienteDAO;
    private Paciente pacienteSelecionado;
    private HashMap<String, Medico> listaMedicos;
    private String[] selectMedicos;
    private String[] listaIdMedicos;

    public InserirConsultaView(Paciente paciente) {
        consultaDAO = new ConsultaDAO();
        medicoDAO = new MedicoDAO();
        pacienteDAO = new PacienteDAO();
        this.pacienteSelecionado = paciente;
        initComponents();
        jTextField2.setText(paciente.getNome());

        try {
            this.listaMedicos = medicoDAO.getMedicos();
        } catch (ClassNotFoundException | IOException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
        }

        this.selectMedicos = new String[listaMedicos.keySet().size()];
        this.listaIdMedicos = new String[listaMedicos.keySet().size()];
        int index = 0;
        for (String id : listaMedicos.keySet()) {
            Medico medico = listaMedicos.get(id);
            listaIdMedicos[index] = id;
            selectMedicos[index] = medico.getNome();
            index++;
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(this.selectMedicos));
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inserir consulta");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados básicos"));

        jLabel2.setText("Paciente:");

        jTextField2.setEditable(false);

        jLabel10.setText("Médico:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>());

        jLabel6.setText("Data da consulta");

        jLabel9.setText("Ano:");

        jLabel18.setText("Mês:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        jLabel19.setText("Dia:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06",
                "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
                "24", "25", "26", "27", "28", "29", "30", "31" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "30" }));

        jLabel8.setText("Minuto");

        jLabel7.setText("Hora");

        jLabel5.setText("Horário da consulta:");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
                        "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout
                .setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout
                                        .createSequentialGroup().addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel2)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField2))
                                                .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel10)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jComboBox1, 0,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addContainerGap())
                                .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel6).addGap(0, 0,
                                        Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel5).addGap(183, 292,
                                        Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                        .createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout
                                                        .createSequentialGroup().addComponent(jLabel7)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jComboBox5, 0,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout
                                                        .createSequentialGroup().addComponent(jLabel9)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField15,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 158,
                                                                Short.MAX_VALUE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel18)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jComboBox3, 0, 107, Short.MAX_VALUE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel19)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jComboBox4, 0,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel8)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jComboBox2, 0,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)))))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10).addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18).addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel19).addComponent(jComboBox4,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9).addComponent(jLabel18).addComponent(jComboBox3,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18).addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(21, Short.MAX_VALUE)));

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
                        jPanel3Layout.createSequentialGroup().addContainerGap(295, Short.MAX_VALUE)
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
        Consulta consulta;
        LocalDateTime data = LocalDateTime.parse(
                jComboBox4.getSelectedItem().toString() + "/" + jComboBox3.getSelectedItem().toString() + "/"
                        + jTextField15.getText() + " " + jComboBox5.getSelectedItem().toString() + ":"
                        + jComboBox2.getSelectedItem().toString() + ":00",
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        HashMap<String, Consulta> consultas;
        try {
            consultas = consultaDAO.getConsultas();
            for (String id : consultas.keySet()) {
                Consulta _consulta = consultas.get(id);
                if (_consulta.getMedico().getId()
                        .equals(medicoDAO.getMedico(listaIdMedicos[jComboBox1.getSelectedIndex()]).getId())
                        && data.compareTo(_consulta.getData()) == 0) {
                    JOptionPane.showMessageDialog(null, "O médico já possui uma consulta neste horário", "Erro!",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            JOptionPane.showMessageDialog(null, "A data esta inválida", "Erro!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            consulta = new Consulta(pacienteDAO.getPaciente(this.pacienteSelecionado.getId()),
                    medicoDAO.getMedico(listaIdMedicos[jComboBox1.getSelectedIndex()]), data, false, null);
            this.pacienteSelecionado.addConsulta(consulta);
            this.pacienteDAO.editPaciente(this.pacienteSelecionado.getId(), this.pacienteSelecionado);
        } catch (ClassNotFoundException | IOException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            this.consultaDAO.addConsulta(consulta);
            JOptionPane.showMessageDialog(null, "Consulta marcada com sucesso", "Sucesso!",
                    JOptionPane.INFORMATION_MESSAGE);
            SecretarioMasterView secretarioMasterView = new SecretarioMasterView();
            secretarioMasterView.pack();
            secretarioMasterView.setLocationRelativeTo(null);
            secretarioMasterView.setVisible(true);
            this.dispose();
        } catch (ClassNotFoundException | IOException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro!", JOptionPane.WARNING_MESSAGE);
        }
    }

    /*
     * Botão cancelar
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        SecretarioMasterView secretarioMasterView = new SecretarioMasterView();
        secretarioMasterView.pack();
        secretarioMasterView.setLocationRelativeTo(null);
        secretarioMasterView.setVisible(true);
        this.dispose();
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField2;
}
