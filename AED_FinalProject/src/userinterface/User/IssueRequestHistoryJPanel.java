/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.User;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.Conversation;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class IssueRequestHistoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form IssueRequestHistoryJPanel
     */
     private JPanel userProcessContainer;
    private UserAccount ua;

    public IssueRequestHistoryJPanel(JPanel userProcessContainer, UserAccount ua) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ua = ua;
        populateTable();
    }
        public void populateConversation(WorkRequest wr)
    {
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        UserAccount temp=null;
        for(Conversation c : wr.getConversation()){
            if(!(temp==c.getUa()))
            {
                textArea.append("\n");
            }
            textArea.append(c.getUa()+ ":  "+c.getMsg()+ "\n");
            temp=c.getUa();

        }
    }

    public void populateTable()
    {
        DefaultTableModel dtm = (DefaultTableModel)tblIRQueue.getModel();
        dtm.setRowCount(0);
        
        for(WorkRequest wr : ua.getWorkQueue().getWorkRequestList()){
            if(wr.getStatus().equalsIgnoreCase("Completed"))
            {
            Object row[] = new Object[dtm.getColumnCount()];
            
            row[0] = wr;
            row[1] = wr.getTitle();
            row[2]=wr.getStatus();

            dtm.addRow(row);
            }
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
        tblIRQueue = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        textArea = new javax.swing.JTextArea();
        btnBack1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 0));
        jLabel7.setText("Chat History:");

        textArea.setColumns(20);
        textArea.setRows(5);

        btnBack1.setBackground(new java.awt.Color(0, 153, 153));
        btnBack1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnBack1.setForeground(new java.awt.Color(255, 255, 255));
        btnBack1.setText("<<");
        btnBack1.setMaximumSize(new java.awt.Dimension(200, 200));
        btnBack1.setMinimumSize(new java.awt.Dimension(200, 200));
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textArea, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addGap(27, 27, 27)
                .addComponent(textArea, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblIRQueueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIRQueueMouseClicked
        // TODO add your handling code here:
                WorkRequest wr = (WorkRequest) tblIRQueue.getValueAt(tblIRQueue.getSelectedRow(), 0);
        
        populateConversation(wr);

    }//GEN-LAST:event_tblIRQueueMouseClicked

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBack1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblIRQueue;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
