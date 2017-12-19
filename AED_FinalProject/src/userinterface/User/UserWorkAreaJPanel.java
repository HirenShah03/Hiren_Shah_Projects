/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.User;

import Business.Allergy.Allergy;
import Business.Camps.Camps;
import Business.EcoSystem;
import Business.Enterprise.AlertEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HealthEnterprise;
import Business.Epidemic.Epidemic;
import Business.Network.Network;
import Business.Organization.AlertOrganization;
import Business.Organization.CampOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kothari
 */
public class UserWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UserWorkAreaJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    EcoSystem system;
    public UserWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.system = system;
        userName.setText(account.getEmployee().getFname()+" "+account.getEmployee().getFname());
        userImage.setIcon(ResizeImage(account.getEmployee().getImagePath()));
       // populateNetworkCombo();
        populateCountryCombo();

        populateAlerts();
    }
    public void populateCountryCombo(){
        comboCountry.removeAllItems();
                for(Network n : system.getNetworkList()){
                    comboCountry.addItem(n.getCountry());
                }
    }
    public ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(168, 156, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

//    public void populateNetworkCombo(){
//        for(Network n : system.getNetworkList()){
//            comboNetwork.addItem(n);
//        }
//    }   
    public void populateCityCombo(){
                comboCity.removeAllItems();

        for(Network n : system.getNetworkList()){
            comboCity.addItem(n);
        }
    }
    public void populateStateCombo(){
                        comboState.removeAllItems();

        for(Network n : system.getNetworkList()){
            comboState.addItem(n.getState());
        }
    }

    public void populateAlerts()
    {
        Timer time = new Timer(); // Instantiate Timer Object
        TimerTask st = new TimerTask() {
        @Override
            public void run() {
                System.out.println("A");
                Network n = (Network)comboCity.getSelectedItem();
                DefaultTableModel model = (DefaultTableModel)tblAlert.getModel();
                model.setRowCount(0);
                for(Enterprise ent : n.getEnterpriseDirectory().getEnterpriseList()){
                    if(ent instanceof AlertEnterprise){
                        for(Organization org : ent.getOrganizationDirectory().getOrganizationList()){
                            if(org instanceof AlertOrganization){
//                                System.out.println("Hereeeeeeee"+((AlertOrganization) org).getAllergyList().size());
                                //for Allergies
                                for(Allergy allergy:((AlertOrganization) org).getAllergyList())
                                {
//                                    if(account.getMedicalHistory().getAllergyList().contains(allergy.getAllergy_by())){
                                        String print="<html> Allergy by <b>"+allergy.getAllergy_by()+"</b> might occur as it has crossed the threshold value in your area <br>"
                                                +"Symptoms of this allergy are: <b>"+allergy.getSymptoms()+"</b><br>"
                                                +"Precautions that should be taken: <b>"+allergy.getPrecautions()+"</b></html>";
                                        Object row[]=new Object[model.getColumnCount()];
                                        row[0] = print;
                                        model.addRow(row);
//                                    }
                                }
                                //for Epidemics
                                for(Epidemic epidemic:((AlertOrganization) org).getEpidemicList())
                                {
                                    String print="<html> Epidemic of <b>"+epidemic.getEpidemicOf()+"</b> is spreading in your area <br>"
                                            +"Precautions of this epidemic are: <b>"+epidemic.getPrecautions()+"</b><br>"
                                            +"Vaccinations that should be taken: <b>"+epidemic.getVaccinations()+"</b></html>";
                                    Object row[]=new Object[model.getColumnCount()];
                                    row[0] = print;
                                    model.addRow(row);
                                }
                            }
                        }
                    }
                    //for Camps
                    if(ent instanceof HealthEnterprise){
                        for(Organization org : ent.getOrganizationDirectory().getOrganizationList()){
                            if(org instanceof CampOrganization){
//                                System.out.println("Hereeeeeeee"+((AlertOrganization) org).getAllergyList().size());
                                for(Camps c:((CampOrganization) org).getCampsList())
                                {
                                    String print="<html> <b>"+c.getCampName()+"</b><br>"
                                            +"<b>Held On: </b>"+c.getDate()+" at <b>Location:<b>"+c.getLocation()+"<br>"
                                            +"<b>Deatils Regarding the Camp: </b>"+c.getDescription()+"<br>"
                                            + "<b>Contact Details:</b>"+c.getContact()+"</html>";
                                    Object row[]=new Object[model.getColumnCount()];
                                    row[0] = print;
                                    model.addRow(row);
                                }
                            }
                        }
                    }
                }
            }
        }; // Instantiate SheduledTask class
        time.schedule(st, 0, 1000); // Create Repetitively task for every 1 secs
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(SensorValueGenerator.class.getName()).log(Level.SEVERE, null, ex);
//        }
                
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAlert = new javax.swing.JTable();
        userName = new javax.swing.JLabel();
        userImage = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnBack1 = new javax.swing.JButton();
        btnBack2 = new javax.swing.JButton();
        comboState = new javax.swing.JComboBox<>();
        comboCountry = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        comboCity = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Welcome");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("System Alerts:");

        tblAlert.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "AlertMessage"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAlert.setRowHeight(46);
        jScrollPane3.setViewportView(tblAlert);
        if (tblAlert.getColumnModel().getColumnCount() > 0) {
            tblAlert.getColumnModel().getColumn(0).setHeaderValue("AlertMessage");
        }

        userName.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        userName.setText("lblName");

        userImage.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));

        btnBack.setBackground(new java.awt.Color(0, 153, 153));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Manage Requests");
        btnBack.setMaximumSize(new java.awt.Dimension(200, 200));
        btnBack.setMinimumSize(new java.awt.Dimension(200, 200));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnBack1.setBackground(new java.awt.Color(0, 153, 153));
        btnBack1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnBack1.setForeground(new java.awt.Color(255, 255, 255));
        btnBack1.setText("View Nearby Pharmacists");
        btnBack1.setMaximumSize(new java.awt.Dimension(200, 200));
        btnBack1.setMinimumSize(new java.awt.Dimension(200, 200));
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        btnBack2.setBackground(new java.awt.Color(0, 153, 153));
        btnBack2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnBack2.setForeground(new java.awt.Color(255, 255, 255));
        btnBack2.setText("View Medical History");
        btnBack2.setMaximumSize(new java.awt.Dimension(200, 200));
        btnBack2.setMinimumSize(new java.awt.Dimension(200, 200));
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });

        comboState.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboStateItemStateChanged(evt);
            }
        });

        comboCountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCountryItemStateChanged(evt);
            }
        });
        comboCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCountryActionPerformed(evt);
            }
        });

        jLabel17.setText("City");

        jLabel16.setText("State");

        jLabel15.setText("Country");

        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Network Selection:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(userImage, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(48, 48, 48)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(comboState, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboCity, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(46, 46, 46))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userImage, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(comboCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(comboState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(comboCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        // TODO add your handling code here:
                ManageRequestsJPanel panel = new ManageRequestsJPanel(userProcessContainer, account, system);
        userProcessContainer.add("ManageRequestsJPanel", panel);
        ((CardLayout)userProcessContainer.getLayout()).next(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
        Network n = (Network)comboCity.getSelectedItem();
        ViewPharmacistsJPanel panel = new ViewPharmacistsJPanel(userProcessContainer, account, n);
        userProcessContainer.add("ViewPharmacistsJPanel", panel);
        ((CardLayout)userProcessContainer.getLayout()).next(userProcessContainer);
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        // TODO add your handling code here:
                MedicalHistoryJPanel panel = new MedicalHistoryJPanel(userProcessContainer, account, system);
        userProcessContainer.add("MedicalHistoryJPanel", panel);
        ((CardLayout)userProcessContainer.getLayout()).next(userProcessContainer);
    }//GEN-LAST:event_btnBack2ActionPerformed

    private void comboStateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboStateItemStateChanged
        // TODO add your handling code here:
        populateCityCombo();
    }//GEN-LAST:event_comboStateItemStateChanged

    private void comboCountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCountryItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCountryItemStateChanged

    private void comboCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCountryActionPerformed
        // TODO add your handling code here:
        populateStateCombo();
    }//GEN-LAST:event_comboCountryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack2;
    private javax.swing.JComboBox<Network> comboCity;
    private javax.swing.JComboBox<String> comboCountry;
    private javax.swing.JComboBox<String> comboState;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblAlert;
    private javax.swing.JLabel userImage;
    private javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables
}
