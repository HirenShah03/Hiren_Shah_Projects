/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.DoctorRole;

import Business.Camps.Camps;
import Business.Enterprise.Enterprise;
import Business.Organization.CampOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Madhuja
 */
public class ViewCampsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewCampsJPanel
     */
    private JPanel userProcessContainer;
    private DoctorOrganization doctorOrganization;
    private Enterprise enterprise;
    private Camps camps;
    private UserAccount ua;
    public ViewCampsJPanel( JPanel userProcessContainer, UserAccount ua, Organization organization,Enterprise enterprise) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.enterprise = enterprise;
        this.doctorOrganization = (DoctorOrganization) organization;
        this.ua = ua;
        populateCamps();
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
        tblCamps = new javax.swing.JTable();
        btnAttending = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("View Camps");

        tblCamps.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Location", "DateTime", "Description", "Doctors", "Contact"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCamps);

        btnAttending.setBackground(new java.awt.Color(0, 153, 153));
        btnAttending.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnAttending.setForeground(new java.awt.Color(255, 255, 255));
        btnAttending.setText("Attending");
        btnAttending.setMaximumSize(new java.awt.Dimension(200, 200));
        btnAttending.setMinimumSize(new java.awt.Dimension(200, 200));
        btnAttending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttendingActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 153, 153));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<< Back");
        btnBack.setMaximumSize(new java.awt.Dimension(200, 200));
        btnBack.setMinimumSize(new java.awt.Dimension(200, 200));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnAttending, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(163, 163, 163))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAttending, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAttendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttendingActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblCamps.getSelectedRow();
        if(selectedRow < 0)
        {
            JOptionPane.showMessageDialog(null,"Please select row","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            this.camps = (Camps) tblCamps.getValueAt(selectedRow,0);
            this.camps.getDoctorList().add(ua);
            JOptionPane.showMessageDialog(null,"Doctor assigned to camp successfully!");
            this.camps = null;
            populateCamps();
        }
    }//GEN-LAST:event_btnAttendingActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        //this.camps = null;
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    public void populateCamps(){
        DefaultTableModel model = (DefaultTableModel) tblCamps.getModel();
        model.setRowCount(0);
        CampOrganization campOrg=null;
        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof CampOrganization)
            {
                campOrg =(CampOrganization) org;
            }
        }
        for (Camps camp : campOrg.getCampsList()) {
            Object[] row = new Object[model.getColumnCount()];
            row[0] = camp;
            row[1] = camp.getLocation();
            row[2] = camp.getDate();
            row[3] = camp.getDescription();
              String doctorName="";
              for(UserAccount u: camp.getDoctorList())
              {
                  doctorName += u.getEmployee().getName()+",";
              }
            row[4] = doctorName;
            row[5] = camp.getContact();
            model.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAttending;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCamps;
    // End of variables declaration//GEN-END:variables
}
