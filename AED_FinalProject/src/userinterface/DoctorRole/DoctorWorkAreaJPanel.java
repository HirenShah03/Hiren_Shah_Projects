/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.DoctorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ConsultWorkRequest;
import Business.WorkQueue.Conversation;
import Business.WorkQueue.IssueWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.DoctorRole.LabRequestJPanel;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.DoctorRole.RaiseConsultRequestJPanel;

/**
 *
 * @author Madhuja
 */
public class DoctorWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount ua;
    private Organization organization;
    private Enterprise enterprise;
    
    public DoctorWorkAreaJPanel(JPanel userProcessContainer, UserAccount ua,Enterprise enterprise, Organization organization, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.ua = ua;
        this.organization = organization;
        this.enterprise = enterprise;
        populateTable();
        lblRating.setText("Current Rating:  "+ua.getRating()+"/5");
    }
    
    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel)tblIRQueue.getModel();
        dtm.setRowCount(0);
        if(comboRequestType.getSelectedItem().toString().equals("Issue Requests")){
            for(WorkRequest wr : organization.getWorkQueue().getWorkRequestList()){
                if(wr instanceof IssueWorkRequest){
                    if(!wr.getStatus().equalsIgnoreCase("Completed"))
                    {
                        Object row[] = new Object[dtm.getColumnCount()];

                        row[0] = wr;
                        row[1] = wr.getTitle();
                        row[2]=wr.getStatus();
                        dtm.addRow(row);
                    }
                }
            }
        }else{
            for(WorkRequest wr : ua.getWorkQueue().getWorkRequestList()){
                if(wr instanceof ConsultWorkRequest){
                    System.out.println(wr);
//                    if(!wr.getStatus().equalsIgnoreCase("Completed"))
                    {
                        Object row[] = new Object[dtm.getColumnCount()];
                        row[0] = wr;
                        row[1] = wr.getTitle();
                        row[2]=wr.getStatus();
                        dtm.addRow(row);
                    }
                }
            }
            btnConsultDoctor.setEnabled(false);
            btnPatientHistory.setEnabled(false);
            btnSubmit.setEnabled(false);
        }
    }
    
    public void populateConversation(WorkRequest wr){
        DefaultTableModel dtm = (DefaultTableModel)tblConversation.getModel();
        dtm.setRowCount(0);
        
        for(Conversation c : wr.getConversation()){
            Object row[] = new Object[dtm.getColumnCount()];
            row[0] = c.getUa();
            row[1] = c.getMsg();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIRQueue = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMsg = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblConversation = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblRating = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboRequestType = new javax.swing.JComboBox<>();
        btnRefresh = new javax.swing.JButton();
        btnViewCamp = new javax.swing.JButton();
        btnPatientHistory = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        btnConsultDoctor = new javax.swing.JButton();
        btnViewLabRequests = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Request Queue");

        tblIRQueue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IR Number", "Title", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblIRQueue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIRQueueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblIRQueue);

        txtMsg.setColumns(20);
        txtMsg.setRows(5);
        txtMsg.setEnabled(false);
        txtMsg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMsgKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(txtMsg);

        tblConversation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sender", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblConversation.setColumnSelectionAllowed(true);
        jScrollPane3.setViewportView(tblConversation);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setText("Request Conversation");

        lblRating.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        lblRating.setText("lblRating");

        jLabel3.setText("Request Type:");

        comboRequestType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Issue Requests", "Consultation Requests" }));
        comboRequestType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRequestTypeActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(0, 153, 153));
        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.setMaximumSize(new java.awt.Dimension(200, 200));
        btnRefresh.setMinimumSize(new java.awt.Dimension(200, 200));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnViewCamp.setBackground(new java.awt.Color(0, 153, 153));
        btnViewCamp.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnViewCamp.setForeground(new java.awt.Color(255, 255, 255));
        btnViewCamp.setText("View Camps");
        btnViewCamp.setMaximumSize(new java.awt.Dimension(200, 200));
        btnViewCamp.setMinimumSize(new java.awt.Dimension(200, 200));
        btnViewCamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewCampActionPerformed(evt);
            }
        });

        btnPatientHistory.setBackground(new java.awt.Color(0, 153, 153));
        btnPatientHistory.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnPatientHistory.setForeground(new java.awt.Color(255, 255, 255));
        btnPatientHistory.setText("Patient History");
        btnPatientHistory.setMaximumSize(new java.awt.Dimension(200, 200));
        btnPatientHistory.setMinimumSize(new java.awt.Dimension(200, 200));
        btnPatientHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientHistoryActionPerformed(evt);
            }
        });

        btnSubmit.setBackground(new java.awt.Color(0, 153, 153));
        btnSubmit.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Prescribe Medicine");
        btnSubmit.setMaximumSize(new java.awt.Dimension(200, 200));
        btnSubmit.setMinimumSize(new java.awt.Dimension(200, 200));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnConsultDoctor.setBackground(new java.awt.Color(0, 153, 153));
        btnConsultDoctor.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnConsultDoctor.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultDoctor.setText("Consult Another Doctor");
        btnConsultDoctor.setMaximumSize(new java.awt.Dimension(200, 200));
        btnConsultDoctor.setMinimumSize(new java.awt.Dimension(200, 200));
        btnConsultDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultDoctorActionPerformed(evt);
            }
        });

        btnViewLabRequests.setBackground(new java.awt.Color(0, 153, 153));
        btnViewLabRequests.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnViewLabRequests.setForeground(new java.awt.Color(255, 255, 255));
        btnViewLabRequests.setText("View Lab Requests");
        btnViewLabRequests.setMaximumSize(new java.awt.Dimension(200, 200));
        btnViewLabRequests.setMinimumSize(new java.awt.Dimension(200, 200));
        btnViewLabRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewLabRequestsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblRating))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(comboRequestType, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnPatientHistory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnViewCamp, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(154, 154, 154))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                        .addComponent(jScrollPane2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnConsultDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(65, 65, 65)
                            .addComponent(btnViewLabRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblRating))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboRequestType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnViewCamp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnPatientHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewLabRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblIRQueueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIRQueueMouseClicked
        // TODO add your handling code here:
        WorkRequest wr = (WorkRequest) tblIRQueue.getValueAt(tblIRQueue.getSelectedRow(), 0);
        populateConversation(wr);
        txtMsg.setEnabled(true);
        if(comboRequestType.getSelectedItem().toString().equals("Issue Requests")){
            btnSubmit.setEnabled(true);
            btnConsultDoctor.setEnabled(true);
            btnPatientHistory.setEnabled(true);
        }
    }//GEN-LAST:event_tblIRQueueMouseClicked

    private void txtMsgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMsgKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == evt.VK_ENTER) {
            if(txtMsg.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Please enter the message first!","Warning",JOptionPane.WARNING_MESSAGE);
            }else{
                WorkRequest wr = (WorkRequest)tblIRQueue.getValueAt(tblIRQueue.getSelectedRow(), 0);

                Conversation c = new Conversation();
                c.setMsg(txtMsg.getText());
                c.setUa(ua);
                wr.getConversation().add(c);
                if(comboRequestType.getSelectedItem().equals("Issue Requests")){
                    ((IssueWorkRequest)wr).setDoctorAssigned(ua);
                }
                wr.setStatus("Pending at user");
                JOptionPane.showMessageDialog(null, "Message has been sent back to the user!");
                populateTable();
                populateConversation(wr);
                txtMsg.setEnabled(false);
                btnSubmit.setEnabled(false);
                btnConsultDoctor.setEnabled(false);
                btnPatientHistory.setEnabled(false);
            }
        } 
    }//GEN-LAST:event_txtMsgKeyPressed

    private void comboRequestTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRequestTypeActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_comboRequestTypeActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnViewCampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewCampActionPerformed
        // TODO add your handling code here:
         ViewCampsJPanel ViewCampsJPanel = new ViewCampsJPanel(userProcessContainer,ua,organization,enterprise);
        userProcessContainer.add("ViewCampsJPanel", ViewCampsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewCampActionPerformed

    private void btnPatientHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientHistoryActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblIRQueue.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select an issue request to get user history!","Warning",JOptionPane.WARNING_MESSAGE);
        }else{
            WorkRequest wr = (WorkRequest)tblIRQueue.getValueAt(tblIRQueue.getSelectedRow(), 0);

            userinterface.DoctorRole.ViewPatientHistoryJpanel viewPatientHistoryJpanel = new userinterface.DoctorRole.ViewPatientHistoryJpanel(userProcessContainer,organization,enterprise,wr);
            userProcessContainer.add("ViewCampsJPanel", viewPatientHistoryJpanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnPatientHistoryActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
       int selectedRow = tblIRQueue.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select an issue request to prescribe first!","Warning",JOptionPane.WARNING_MESSAGE);
        }else{
            WorkRequest wr = (WorkRequest)tblIRQueue.getValueAt(tblIRQueue.getSelectedRow(), 0);
            userinterface.DoctorRole.PrescribeMedicineJPanel panel = new userinterface.DoctorRole.PrescribeMedicineJPanel(userProcessContainer, wr,ua,organization,business);
            userProcessContainer.add("PrescribeMedicineJPanel",panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnConsultDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultDoctorActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblIRQueue.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select an issue request to get user history!","Warning",JOptionPane.WARNING_MESSAGE);
        }else{
            WorkRequest wr = (WorkRequest)tblIRQueue.getValueAt(tblIRQueue.getSelectedRow(), 0);
            RaiseConsultRequestJPanel panel = new RaiseConsultRequestJPanel(userProcessContainer, ua, wr, business);
            userProcessContainer.add("RaiseConsultRequestJPanel", panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnConsultDoctorActionPerformed

    private void btnViewLabRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewLabRequestsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblIRQueue.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select an issue request to get user history!","Warning",JOptionPane.WARNING_MESSAGE);
        }else{
            WorkRequest wr = (WorkRequest)tblIRQueue.getValueAt(tblIRQueue.getSelectedRow(), 0);
            LabRequestJPanel panel = new LabRequestJPanel(userProcessContainer, ua, wr, enterprise);
            userProcessContainer.add("RaiseConsultRequestJPanel", panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnViewLabRequestsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultDoctor;
    private javax.swing.JButton btnPatientHistory;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnViewCamp;
    private javax.swing.JButton btnViewLabRequests;
    private javax.swing.JComboBox<String> comboRequestType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblRating;
    private javax.swing.JTable tblConversation;
    private javax.swing.JTable tblIRQueue;
    private javax.swing.JTextArea txtMsg;
    // End of variables declaration//GEN-END:variables
}
