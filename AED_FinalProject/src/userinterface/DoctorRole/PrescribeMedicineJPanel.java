/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.EcoSystem;
import Business.Medicines.Medicine;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.Conversation;
import Business.WorkQueue.IssueWorkRequest;
import Business.WorkQueue.Prescription;
import Business.WorkQueue.PrescriptionItems;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class PrescribeMedicineJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PrescribeMedicineJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount ua;
    private Organization organization;
    private WorkRequest workRequest;
    private EcoSystem business;
    Prescription p;
    public PrescribeMedicineJPanel(JPanel userProcessContainer,WorkRequest workRequest,UserAccount ua,Organization organization,EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ua = ua;
        this.organization = organization;
        this.workRequest=workRequest;
        this.business=business;
        populateConversation();
        p=((IssueWorkRequest)workRequest).getPrescription();
        populatePrescriptionTable();
        populateCombo();
    }
    public void populateCombo()
    {
        for(Medicine medicine:business.getMedicineList())
        {
            medicineList.addItem(medicine);
        }
    }
    public void populateConversation()
    {
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        UserAccount temp=null;
        for(Conversation c : workRequest.getConversation()){
            if(!(temp==c.getUa()))
            {
                textArea.append("\n");
            }
            textArea.append(c.getUa()+ ":  "+c.getMsg()+ "\n");
            temp=c.getUa();

        }
    }
    public void populatePrescriptionTable()
    {
        DefaultTableModel dtm = (DefaultTableModel)prescriptionTable.getModel();
        dtm.setRowCount(0);
        
        for(PrescriptionItems prescriptionItems : ((IssueWorkRequest)workRequest).getPrescription().getPrescriptionItems()){
            Object row[] = new Object[3];
            row[0] = prescriptionItems;
            row[1] = prescriptionItems.getDosage();
            row[2] = prescriptionItems.getDate();
            dtm.addRow(row);
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        quantityTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        prescriptionTable = new javax.swing.JTable();
        medicineList = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        submitPrescription = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        jLabel1.setText("Medicine: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("Enter Prescription Details:");

        quantityTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTxtActionPerformed(evt);
            }
        });

        jLabel2.setText("Dosage:");

        prescriptionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine", "Quantity", "Prescribed Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(prescriptionTable);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 0));
        jLabel7.setText("Chat History:");

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.setMaximumSize(new java.awt.Dimension(200, 200));
        jButton1.setMinimumSize(new java.awt.Dimension(200, 200));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        submitPrescription.setBackground(new java.awt.Color(0, 153, 153));
        submitPrescription.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        submitPrescription.setForeground(new java.awt.Color(255, 255, 255));
        submitPrescription.setText("Delete");
        submitPrescription.setMaximumSize(new java.awt.Dimension(200, 200));
        submitPrescription.setMinimumSize(new java.awt.Dimension(200, 200));
        submitPrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitPrescriptionActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("<<Back");
        jButton2.setMaximumSize(new java.awt.Dimension(200, 200));
        jButton2.setMinimumSize(new java.awt.Dimension(200, 200));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(medicineList, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(submitPrescription, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(395, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medicineList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitPrescription, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void quantityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(quantityTxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter dosage for the medicine!","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        PrescriptionItems pi=p.addPrescription();
        pi.setMedicine((Medicine)medicineList.getSelectedItem());
        pi.setDosage(quantityTxt.getText());
        pi.setDate(new Date());
        ((IssueWorkRequest)workRequest).setPrescription(p);
        ((IssueWorkRequest)workRequest).setStatus("");
        populatePrescriptionTable();
        JOptionPane.showMessageDialog(null, "Prescription Added!");
        quantityTxt.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void submitPrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitPrescriptionActionPerformed
        // TODO add your handling code here:
        int selectedRow = prescriptionTable.getSelectedRow();
        
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a newly added row from the Prescription to delete!","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        PrescriptionItems pi = (PrescriptionItems)prescriptionTable.getValueAt(selectedRow, 0);
        if(pi.isStatus()){
            JOptionPane.showMessageDialog(null, "The medicine has been already taken by the User. It cannot be deleted.","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        p.getPrescriptionItems().remove(pi);
        JOptionPane.showMessageDialog(null, "Prescribed Medicine has been deleted!");
        populatePrescriptionTable();
    }//GEN-LAST:event_submitPrescriptionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        userInterface.DoctorRole.DoctorWorkAreaJPanel panel = (userInterface.DoctorRole.DoctorWorkAreaJPanel)userProcessContainer.getComponents()[userProcessContainer.getComponents().length-1];
        panel.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox medicineList;
    private javax.swing.JTable prescriptionTable;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JButton submitPrescription;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
