package app.views;

import java.time.format.DateTimeFormatter;

import javax.swing.table.DefaultTableModel;

import app.models.Consulta;
import app.models.Paciente;

public class HistoricoPacienteView extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private DefaultTableModel tabelaConsultas;

    public HistoricoPacienteView(Paciente paciente) {
        int index = 0;
        Object[][] consultasData = new Object[paciente.getConsultas().size()][3];
        for (Consulta consulta : paciente.getConsultas()) {
            consultasData[index][0] = consulta.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            consultasData[index][1] = consulta.getMedico() != null ? consulta.getPaciente().getNome() : "";
            consultasData[index][2] = consulta.getConsultaRealizada() ? "Sim" : "Não";
            index++;
        }
        this.tabelaConsultas = new DefaultTableModel(consultasData,
                new String[] { "Nome", "Telefone", "Data de admissão", "NCTPS" });
        initComponents();
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Histórico do paciente");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabela com o histórico"));

        jTable1.setModel(this.tabelaConsultas);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                        .addContainerGap()));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }

    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}
