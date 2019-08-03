/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.User;

import Business.EcoSystem;
import Business.MedicalHistory.MedicalHistory;
import Business.MedicalHistory.Questionnaire;
import Business.UserAccount.UserAccount;
import Validation.Validation;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author kothari
 */
public class MedicalHistoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MedicalHistoryJPanel
     */
    private JPanel userProcessContainer;
   // private EcoSystem system;
    private UserAccount ua;
    
    public MedicalHistoryJPanel(JPanel userProcessContainer, UserAccount ua, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
       // this.system = system;
        this.ua = ua;
                buttonGroup1.add(AlchoholN);
        buttonGroup1.add(AlchoholY);
        buttonGroup2.add(OperationY);
        buttonGroup2.add(OperationN);
        buttonGroup3.add(PreviousMediN);
        buttonGroup3.add(PreviousMediY);
        buttonGroup4.add(dietN);
        buttonGroup4.add(dietY);

//        System.out.println(ua.getMedicalHistory().getDiseaseList().get(0));
//        System.out.println(ua.getMedicalHistory().getAllergyList().get(0));
//        System.out.println(ua.getMedicalHistory().getQuestionnaireList().get(0).getQuestion());
//        System.out.println(ua.getMedicalHistory().getQuestionnaireList().get(0).getComment());
        populateMedicalHistory();
    }
    public void populateMedicalHistory()
    {
        for(String disease:ua.getMedicalHistory().getDiseaseList())
        {
            if(disease.equalsIgnoreCase("High Blood Pressure"))
            {
                highBloodPressure.setSelected(true);
            }

            if(disease.equalsIgnoreCase("High Cholestrol"))
            {
                HighCholestrol.setSelected(true);
            }

            if(disease.equalsIgnoreCase("Kidney Disease"))
            {
                KidneyDisease.setSelected(true);
                
            }

            if(disease.equalsIgnoreCase("Thyroid Problem"))
            {
                ThyroidProblem.setSelected(true);
            }

            if(disease.equalsIgnoreCase("Tuberculosis"))
            {
                Tuberculosis.setSelected(true);
            }

            if(disease.equalsIgnoreCase("Liver Disease"))
            {
                LiverDisease.setSelected(true);
            }

            if(disease.equalsIgnoreCase("Diabetes"))
            {
                Diabetes.setSelected(true);
            }

            if(disease.equalsIgnoreCase("Asthama"))
            {
                Asthama.setSelected(true);
            }

            if(disease.equalsIgnoreCase("Hepatitis"))
            {
                Hepatitis.setSelected(true);
            }
            if(disease.equalsIgnoreCase("lung Disease"))
            {
                lungDisease.setSelected(true);
            }
            if(disease.equalsIgnoreCase("Sinus"))
            {
                Sinus.setSelected(true);
            }
            if(disease.equalsIgnoreCase("HIV"))
            {
                HIV.setSelected(true);
            }
            if(disease.equalsIgnoreCase("Cancer"))
            {
                Cancer.setSelected(true);
            }
            if(disease.equalsIgnoreCase("HyperTension"))
            {
                HyperTension.setSelected(true);
            }
            if(disease.equalsIgnoreCase("Amnesia"))
            {
                Amnesia.setSelected(true);
            }
            if(disease.contains("other:"))
            {
                other.setSelected(true);
                otherTxt.setText(disease.substring(6));
            }
        } 
     //////////////////Allergy////////////////////////
            for(String allergy:ua.getMedicalHistory().getAllergyList())
            {
                System.out.println(allergy);
                if(allergy.equalsIgnoreCase("Aspirin"))
                Aspirin.setSelected(true);

                if(allergy.equalsIgnoreCase("Pencilin"))
                Pencilin.setSelected(true);

                if(allergy.equalsIgnoreCase("Codeine"))
                Codeine.setSelected(true);
              
                if(allergy.equalsIgnoreCase("Local Anesthetics"))
                LocalAnesthetics.setSelected(true);
              
                if(allergy.equalsIgnoreCase("Arcylic"))
                Arcylic.setSelected(true);
               
                if(allergy.equalsIgnoreCase("Metal"))
                Metal.setSelected(true);
                
                if(allergy.equalsIgnoreCase("Latex"))
                Latex.setSelected(true);
                if(allergy.equalsIgnoreCase("pollen grains"))
                pollenGrains.setSelected(true);
                if(allergy.equalsIgnoreCase("uv"))
                UV.setSelected(true);
                
                if(allergy.contains("other:"))
                {
                    otherAllergy.setSelected(true);
                    otherAllergyTxt.setText(allergy.substring(6));
                } 
            }
        for(Questionnaire questionnaire:ua.getMedicalHistory().getQuestionnaireList())
        {
            if(questionnaire.getQuestion().equalsIgnoreCase("Alchohol Usage:"))
            {
                if(questionnaire.getStatus())
                    AlchoholY.setSelected(true);
                else
                    AlchoholN.setSelected(true);
            }
            if(questionnaire.getQuestion().equalsIgnoreCase("Are you taking any medication, pills or drugs?"))
            {
                if(questionnaire.getStatus())
                {
                    PreviousMediY.setSelected(true);
                    PreviousMeditxt.setText(questionnaire.getComment());
                }
                else
                    PreviousMediN.setSelected(true);
            }
            if(questionnaire.getQuestion().equalsIgnoreCase("Have you ever been Hospitalized or had a major operation?"))
            {
                if(questionnaire.getStatus())
                {
                    OperationY.setSelected(true);
                    Operationtxt.setText(questionnaire.getComment());
                }
                else
                    OperationN.setSelected(true);
            }
            if(questionnaire.getQuestion().equalsIgnoreCase("Are you on a special diet?"))
            {
                if(questionnaire.getStatus())
                {
                    dietY.setSelected(true);
                    dietTxt.setText(questionnaire.getComment());
                }
                else
                    dietN.setSelected(true);    
            }
        }
        heightTxt.setText(String.valueOf(ua.getMedicalHistory().getHeight()));
        weightTxt.setText(String.valueOf(ua.getMedicalHistory().getWeight()));
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        PreviousMediY = new javax.swing.JRadioButton();
        PreviousMediN = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        PreviousMeditxt = new javax.swing.JTextField();
        dietY = new javax.swing.JRadioButton();
        dietN = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        dietTxt = new javax.swing.JTextField();
        otherAllergyTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        highBloodPressure = new javax.swing.JCheckBox();
        HighCholestrol = new javax.swing.JCheckBox();
        KidneyDisease = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        ThyroidProblem = new javax.swing.JCheckBox();
        Aspirin = new javax.swing.JCheckBox();
        Tuberculosis = new javax.swing.JCheckBox();
        Pencilin = new javax.swing.JCheckBox();
        Codeine = new javax.swing.JCheckBox();
        LocalAnesthetics = new javax.swing.JCheckBox();
        Arcylic = new javax.swing.JCheckBox();
        Metal = new javax.swing.JCheckBox();
        Latex = new javax.swing.JCheckBox();
        otherAllergy = new javax.swing.JCheckBox();
        lblCustomername7 = new javax.swing.JLabel();
        LiverDisease = new javax.swing.JCheckBox();
        Diabetes = new javax.swing.JCheckBox();
        Asthama = new javax.swing.JCheckBox();
        Hepatitis = new javax.swing.JCheckBox();
        lungDisease = new javax.swing.JCheckBox();
        Sinus = new javax.swing.JCheckBox();
        HIV = new javax.swing.JCheckBox();
        Cancer = new javax.swing.JCheckBox();
        AlchoholY = new javax.swing.JRadioButton();
        HyperTension = new javax.swing.JCheckBox();
        AlchoholN = new javax.swing.JRadioButton();
        Amnesia = new javax.swing.JCheckBox();
        other = new javax.swing.JCheckBox();
        otherTxt = new javax.swing.JTextField();
        lblCustomername4 = new javax.swing.JLabel();
        lblCustomername5 = new javax.swing.JLabel();
        lblCustomername6 = new javax.swing.JLabel();
        OperationY = new javax.swing.JRadioButton();
        OperationN = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        Operationtxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lblCustomername8 = new javax.swing.JLabel();
        lblCustomername9 = new javax.swing.JLabel();
        heightTxt = new javax.swing.JTextField();
        weightTxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        UV = new javax.swing.JCheckBox();
        pollenGrains = new javax.swing.JCheckBox();
        lblCustomername10 = new javax.swing.JLabel();
        lblCustomername11 = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();
        btnBack2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        PreviousMediY.setText("Yes");
        PreviousMediY.setEnabled(false);
        PreviousMediY.setFocusCycleRoot(true);
        PreviousMediY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PreviousMediYMouseClicked(evt);
            }
        });

        PreviousMediN.setText("No");
        PreviousMediN.setEnabled(false);
        PreviousMediN.setFocusCycleRoot(true);
        PreviousMediN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PreviousMediNMouseClicked(evt);
            }
        });
        PreviousMediN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousMediNActionPerformed(evt);
            }
        });

        jLabel3.setText("Comments:");
        jLabel3.setEnabled(false);
        jLabel3.setFocusCycleRoot(true);

        PreviousMeditxt.setEnabled(false);
        PreviousMeditxt.setFocusCycleRoot(true);
        PreviousMeditxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousMeditxtActionPerformed(evt);
            }
        });

        dietY.setText("Yes");
        dietY.setEnabled(false);
        dietY.setFocusCycleRoot(true);
        dietY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dietYMouseClicked(evt);
            }
        });

        dietN.setText("No");
        dietN.setEnabled(false);
        dietN.setFocusCycleRoot(true);
        dietN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dietNMouseClicked(evt);
            }
        });
        dietN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dietNActionPerformed(evt);
            }
        });

        jLabel5.setText("Comments:");
        jLabel5.setEnabled(false);
        jLabel5.setFocusCycleRoot(true);

        dietTxt.setEnabled(false);
        dietTxt.setFocusCycleRoot(true);
        dietTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dietTxtActionPerformed(evt);
            }
        });

        otherAllergyTxt.setEnabled(false);
        otherAllergyTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherAllergyTxtActionPerformed(evt);
            }
        });

        jLabel7.setText("If yes, please explain:");
        jLabel7.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("Medical History");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("Past Medical History:");

        highBloodPressure.setText("High Blood Pressure");
        highBloodPressure.setEnabled(false);
        highBloodPressure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highBloodPressureActionPerformed(evt);
            }
        });

        HighCholestrol.setText("High Cholestrol");
        HighCholestrol.setEnabled(false);
        HighCholestrol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HighCholestrolActionPerformed(evt);
            }
        });

        KidneyDisease.setText("Kidney Disease");
        KidneyDisease.setEnabled(false);
        KidneyDisease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KidneyDiseaseActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 0));
        jLabel8.setText("Are you allergic to any of the following?");

        ThyroidProblem.setText("Thyroid Problem");
        ThyroidProblem.setEnabled(false);
        ThyroidProblem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThyroidProblemActionPerformed(evt);
            }
        });

        Aspirin.setText("Aspirin");
        Aspirin.setEnabled(false);
        Aspirin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AspirinActionPerformed(evt);
            }
        });

        Tuberculosis.setText("Tuberculosis");
        Tuberculosis.setEnabled(false);
        Tuberculosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TuberculosisActionPerformed(evt);
            }
        });

        Pencilin.setText("Penicilin");
        Pencilin.setEnabled(false);
        Pencilin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PencilinActionPerformed(evt);
            }
        });

        Codeine.setText("Codeine");
        Codeine.setEnabled(false);
        Codeine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodeineActionPerformed(evt);
            }
        });

        LocalAnesthetics.setText("Local Anesthetics");
        LocalAnesthetics.setEnabled(false);
        LocalAnesthetics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalAnestheticsActionPerformed(evt);
            }
        });

        Arcylic.setText("Arcylic");
        Arcylic.setEnabled(false);
        Arcylic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArcylicActionPerformed(evt);
            }
        });

        Metal.setText("Metal");
        Metal.setEnabled(false);
        Metal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MetalActionPerformed(evt);
            }
        });

        Latex.setText("Latex");
        Latex.setEnabled(false);
        Latex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LatexActionPerformed(evt);
            }
        });

        otherAllergy.setText("Other");
        otherAllergy.setEnabled(false);
        otherAllergy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                otherAllergyMouseClicked(evt);
            }
        });
        otherAllergy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherAllergyActionPerformed(evt);
            }
        });

        lblCustomername7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCustomername7.setForeground(new java.awt.Color(0, 102, 0));
        lblCustomername7.setText("Alchohol Usage:");

        LiverDisease.setText("Liver Disease");
        LiverDisease.setEnabled(false);
        LiverDisease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LiverDiseaseActionPerformed(evt);
            }
        });

        Diabetes.setText("Diabetes");
        Diabetes.setEnabled(false);
        Diabetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiabetesActionPerformed(evt);
            }
        });

        Asthama.setText("Asthama");
        Asthama.setEnabled(false);
        Asthama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsthamaActionPerformed(evt);
            }
        });

        Hepatitis.setText("Hepatitis");
        Hepatitis.setEnabled(false);
        Hepatitis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HepatitisActionPerformed(evt);
            }
        });

        lungDisease.setText("Lung Disease");
        lungDisease.setEnabled(false);
        lungDisease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lungDiseaseActionPerformed(evt);
            }
        });

        Sinus.setText("Sinus");
        Sinus.setEnabled(false);
        Sinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SinusActionPerformed(evt);
            }
        });

        HIV.setText("HIV");
        HIV.setEnabled(false);
        HIV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HIVActionPerformed(evt);
            }
        });

        Cancer.setText("Cancer");
        Cancer.setEnabled(false);
        Cancer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancerActionPerformed(evt);
            }
        });

        AlchoholY.setText("Yes");
        AlchoholY.setEnabled(false);
        AlchoholY.setFocusCycleRoot(true);

        HyperTension.setText("Hypertension");
        HyperTension.setEnabled(false);
        HyperTension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HyperTensionActionPerformed(evt);
            }
        });

        AlchoholN.setText("No");
        AlchoholN.setEnabled(false);
        AlchoholN.setFocusCycleRoot(true);
        AlchoholN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlchoholNActionPerformed(evt);
            }
        });

        Amnesia.setText("Amnesia");
        Amnesia.setEnabled(false);
        Amnesia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmnesiaActionPerformed(evt);
            }
        });

        other.setText("Other");
        other.setEnabled(false);
        other.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                otherMouseClicked(evt);
            }
        });
        other.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherActionPerformed(evt);
            }
        });

        otherTxt.setEnabled(false);
        otherTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherTxtActionPerformed(evt);
            }
        });

        lblCustomername4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCustomername4.setForeground(new java.awt.Color(0, 102, 0));
        lblCustomername4.setText("Have you ever been Hospitalized or had a major operation?");

        lblCustomername5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCustomername5.setForeground(new java.awt.Color(0, 102, 0));
        lblCustomername5.setText("Are you taking any medication, pills or drugs?");

        lblCustomername6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCustomername6.setForeground(new java.awt.Color(0, 102, 0));
        lblCustomername6.setText("Are you on a special diet?");

        OperationY.setText("Yes");
        OperationY.setEnabled(false);
        OperationY.setFocusCycleRoot(true);
        OperationY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OperationYMouseClicked(evt);
            }
        });

        OperationN.setText("No");
        OperationN.setEnabled(false);
        OperationN.setFocusCycleRoot(true);
        OperationN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OperationNMouseClicked(evt);
            }
        });
        OperationN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperationNActionPerformed(evt);
            }
        });

        jLabel2.setText("Comments:");
        jLabel2.setEnabled(false);
        jLabel2.setFocusCycleRoot(true);

        Operationtxt.setEnabled(false);
        Operationtxt.setFocusCycleRoot(true);
        Operationtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperationtxtActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 0));
        jLabel9.setText("Personal Details:");

        lblCustomername8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCustomername8.setForeground(new java.awt.Color(0, 102, 0));
        lblCustomername8.setText("Height:");

        lblCustomername9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCustomername9.setForeground(new java.awt.Color(0, 102, 0));
        lblCustomername9.setText("Weight:");

        heightTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heightTxtActionPerformed(evt);
            }
        });

        weightTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weightTxtActionPerformed(evt);
            }
        });

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        UV.setText("UV ");
        UV.setEnabled(false);

        pollenGrains.setText("Pollen Grains");
        pollenGrains.setEnabled(false);

        lblCustomername10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCustomername10.setForeground(new java.awt.Color(0, 102, 0));
        lblCustomername10.setText("cm");

        lblCustomername11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCustomername11.setForeground(new java.awt.Color(0, 102, 0));
        lblCustomername11.setText("Kg");

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

        btnBack2.setBackground(new java.awt.Color(0, 153, 153));
        btnBack2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnBack2.setForeground(new java.awt.Color(255, 255, 255));
        btnBack2.setText(">>");
        btnBack2.setMaximumSize(new java.awt.Dimension(200, 200));
        btnBack2.setMinimumSize(new java.awt.Dimension(200, 200));
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblCustomername7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(AlchoholY)
                                        .addGap(18, 18, 18)
                                        .addComponent(AlchoholN))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblCustomername10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblCustomername9)
                                                .addGap(18, 18, 18)
                                                .addComponent(weightTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblCustomername4))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(OperationY)
                                                .addGap(18, 18, 18)
                                                .addComponent(OperationN))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblCustomername11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(25, 25, 25)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(Operationtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(highBloodPressure)
                                    .addComponent(HighCholestrol)
                                    .addComponent(KidneyDisease)
                                    .addComponent(ThyroidProblem))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Asthama)
                                    .addComponent(Diabetes)
                                    .addComponent(LiverDisease)
                                    .addComponent(Tuberculosis))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(HIV)
                                    .addComponent(Sinus)
                                    .addComponent(lungDisease)
                                    .addComponent(Hepatitis))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(other)
                                        .addGap(18, 18, 18)
                                        .addComponent(otherTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Amnesia)
                                    .addComponent(HyperTension)
                                    .addComponent(Cancer)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(50, 50, 50)
                                .addComponent(jButton2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(pollenGrains)
                                    .addGap(29, 29, 29)
                                    .addComponent(UV)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(otherAllergy)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(otherAllergyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Aspirin)
                                    .addGap(18, 18, 18)
                                    .addComponent(Pencilin)
                                    .addGap(18, 18, 18)
                                    .addComponent(Codeine)
                                    .addGap(26, 26, 26)
                                    .addComponent(LocalAnesthetics)
                                    .addGap(18, 18, 18)
                                    .addComponent(Arcylic)
                                    .addGap(26, 26, 26)
                                    .addComponent(Metal)
                                    .addGap(18, 18, 18)
                                    .addComponent(Latex))))
                        .addGap(68, 68, 68))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCustomername5)
                                .addComponent(lblCustomername6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCustomername8)
                                        .addGap(18, 18, 18)
                                        .addComponent(heightTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9))
                                .addGap(128, 128, 128))
                            .addComponent(btnBack1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PreviousMediY)
                                .addGap(18, 18, 18)
                                .addComponent(PreviousMediN)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(PreviousMeditxt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dietY)
                                .addGap(18, 18, 18)
                                .addComponent(dietN)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(dietTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(13, 13, 13)
                            .addComponent(jLabel6))
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Cancer)
                        .addGap(18, 18, 18)
                        .addComponent(HyperTension)
                        .addGap(18, 18, 18)
                        .addComponent(Amnesia)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(other)
                            .addComponent(otherTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(highBloodPressure)
                                .addComponent(Tuberculosis))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(HighCholestrol)
                                .addComponent(LiverDisease))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(KidneyDisease)
                                .addComponent(Diabetes))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ThyroidProblem)
                                .addComponent(Asthama)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Hepatitis)
                            .addGap(18, 18, 18)
                            .addComponent(lungDisease)
                            .addGap(18, 18, 18)
                            .addComponent(Sinus)
                            .addGap(18, 18, 18)
                            .addComponent(HIV))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LocalAnesthetics)
                        .addComponent(Arcylic)
                        .addComponent(Metal)
                        .addComponent(Latex))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Aspirin)
                            .addComponent(Pencilin))
                        .addComponent(Codeine)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(otherAllergy)
                        .addComponent(otherAllergyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pollenGrains)
                        .addComponent(UV)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AlchoholY)
                        .addComponent(AlchoholN))
                    .addComponent(lblCustomername7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCustomername4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(OperationY)
                                .addComponent(OperationN)
                                .addComponent(jLabel2)
                                .addComponent(Operationtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustomername5)
                            .addComponent(PreviousMediY)
                            .addComponent(PreviousMediN)
                            .addComponent(jLabel3)
                            .addComponent(PreviousMeditxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(lblCustomername6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dietY)
                        .addComponent(dietN)
                        .addComponent(jLabel5)
                        .addComponent(dietTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCustomername8))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustomername9)
                            .addComponent(weightTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCustomername10)
                            .addComponent(lblCustomername11))
                        .addComponent(heightTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PreviousMediYMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PreviousMediYMouseClicked
        // TODO add your handling code here:
        if(PreviousMediY.isSelected())
        PreviousMeditxt.setEnabled(true);
    }//GEN-LAST:event_PreviousMediYMouseClicked

    private void PreviousMediNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PreviousMediNMouseClicked
        // TODO add your handling code here:
        if(PreviousMediN.isSelected())
        PreviousMeditxt.setEnabled(false);
    }//GEN-LAST:event_PreviousMediNMouseClicked

    private void PreviousMediNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousMediNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PreviousMediNActionPerformed

    private void PreviousMeditxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousMeditxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PreviousMeditxtActionPerformed

    private void dietYMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dietYMouseClicked
        // TODO add your handling code here:
        if(dietY.isSelected())
        dietTxt.setEnabled(true);

    }//GEN-LAST:event_dietYMouseClicked

    private void dietNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dietNMouseClicked
        // TODO add your handling code here:
        if(dietN.isSelected())
        dietTxt.setEnabled(false);
    }//GEN-LAST:event_dietNMouseClicked

    private void dietNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dietNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dietNActionPerformed

    private void dietTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dietTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dietTxtActionPerformed

    private void otherAllergyTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherAllergyTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_otherAllergyTxtActionPerformed

    private void highBloodPressureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highBloodPressureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_highBloodPressureActionPerformed

    private void HighCholestrolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HighCholestrolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HighCholestrolActionPerformed

    private void KidneyDiseaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KidneyDiseaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KidneyDiseaseActionPerformed

    private void ThyroidProblemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThyroidProblemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThyroidProblemActionPerformed

    private void AspirinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AspirinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AspirinActionPerformed

    private void TuberculosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TuberculosisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TuberculosisActionPerformed

    private void PencilinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PencilinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PencilinActionPerformed

    private void CodeineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodeineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodeineActionPerformed

    private void LocalAnestheticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalAnestheticsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LocalAnestheticsActionPerformed

    private void ArcylicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArcylicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ArcylicActionPerformed

    private void MetalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MetalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MetalActionPerformed

    private void LatexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LatexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LatexActionPerformed

    private void otherAllergyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_otherAllergyMouseClicked
        // TODO add your handling code here:
        if(otherAllergy.isSelected())
        otherAllergyTxt.setEnabled(true);

        if(!otherAllergy.isSelected())
        otherAllergyTxt.setEnabled(false);
    }//GEN-LAST:event_otherAllergyMouseClicked

    private void otherAllergyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherAllergyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_otherAllergyActionPerformed

    private void LiverDiseaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LiverDiseaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LiverDiseaseActionPerformed

    private void DiabetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiabetesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiabetesActionPerformed

    private void AsthamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsthamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AsthamaActionPerformed

    private void HepatitisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HepatitisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HepatitisActionPerformed

    private void lungDiseaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lungDiseaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lungDiseaseActionPerformed

    private void SinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SinusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SinusActionPerformed

    private void HIVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HIVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HIVActionPerformed

    private void CancerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CancerActionPerformed

    private void HyperTensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HyperTensionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HyperTensionActionPerformed

    private void AlchoholNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlchoholNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlchoholNActionPerformed

    private void AmnesiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmnesiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmnesiaActionPerformed

    private void otherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_otherMouseClicked
        // TODO add your handling code here:
        if(other.isSelected())
        otherTxt.setEnabled(true);

        if(!other.isSelected())
        otherTxt.setEnabled(false);

    }//GEN-LAST:event_otherMouseClicked

    private void otherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_otherActionPerformed

    private void otherTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_otherTxtActionPerformed

    private void OperationYMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OperationYMouseClicked
        // TODO add your handling code here:
        if(OperationY.isSelected())
        Operationtxt.setEnabled(true);
    }//GEN-LAST:event_OperationYMouseClicked

    private void OperationNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OperationNMouseClicked

        // TODO add your handling code here:
        if(OperationN.isSelected())
        Operationtxt.setEnabled(false);
    }//GEN-LAST:event_OperationNMouseClicked

    private void OperationNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OperationNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OperationNActionPerformed

    private void OperationtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OperationtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OperationtxtActionPerformed

    private void heightTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heightTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_heightTxtActionPerformed

    private void weightTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weightTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_weightTxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                   highBloodPressure.setEnabled(true);
                   HighCholestrol.setEnabled(true);
                   KidneyDisease.setEnabled(true);
                   ThyroidProblem.setEnabled(true);
                   Tuberculosis.setEnabled(true);
                   LiverDisease.setEnabled(true);
                   Diabetes.setEnabled(true);
                   Asthama.setEnabled(true);
                   Hepatitis.setEnabled(true);
                   lungDisease.setEnabled(true);
                   Sinus.setEnabled(true);
                   HIV.setEnabled(true);
                   Cancer.setEnabled(true);
                   HyperTension.setEnabled(true);
                   Amnesia.setEnabled(true);
                   other.setEnabled(true);
                   if(other.isSelected())
                   {
                       otherTxt.setEnabled(true);
                   }
                   
                   Aspirin.setEnabled(true);
                   Pencilin.setEnabled(true);
                   Codeine.setEnabled(true);
                   LocalAnesthetics.setEnabled(true);
                   Arcylic.setEnabled(true);
                   Metal.setEnabled(true);
                   Latex.setEnabled(true);
                   pollenGrains.setEnabled(true);
                   UV.setEnabled(true);
                   otherAllergy.setEnabled(true);
                    if(otherAllergy.isSelected())
                   {
                       otherAllergyTxt.setEnabled(true);
                   }

                   AlchoholY.setEnabled(true);
                   AlchoholN.setEnabled(true);
                   OperationN.setEnabled(true);
                   OperationY.setEnabled(true);
                   Operationtxt.setEnabled(true);
                   PreviousMediN.setEnabled(true);
                   PreviousMediY.setEnabled(true);
                   PreviousMeditxt.setEnabled(true);
                   dietN.setEnabled(true);
                   dietY.setEnabled(true);
                   dietTxt.setEnabled(true);
                   
                   heightTxt.setEnabled(true);
                   weightTxt.setEnabled(true);
                   

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                if(buttonGroup1.getSelection()!=null && buttonGroup2.getSelection()!=null && buttonGroup3.getSelection()!=null && buttonGroup4.getSelection()!=null)
        {
        MedicalHistory mh=new MedicalHistory();
    if(highBloodPressure.isSelected())
    mh.getDiseaseList().add(highBloodPressure.getText());

    if(HighCholestrol.isSelected())
    mh.getDiseaseList().add(HighCholestrol.getText());

    if(KidneyDisease.isSelected())
    mh.getDiseaseList().add(KidneyDisease.getText());

    if(ThyroidProblem.isSelected())
    mh.getDiseaseList().add(ThyroidProblem.getText());

    if(Tuberculosis.isSelected())
    mh.getDiseaseList().add(Tuberculosis.getText());

    if(LiverDisease.isSelected())
    mh.getDiseaseList().add(LiverDisease.getText());

     if(Diabetes.isSelected())
    mh.getDiseaseList().add(Diabetes.getText());

     if(Asthama.isSelected())
    mh.getDiseaseList().add(Asthama.getText());
    
     if(Hepatitis.isSelected())
    mh.getDiseaseList().add(Hepatitis.getText());
   
     if(lungDisease.isSelected())
    mh.getDiseaseList().add(lungDisease.getText());
   
     if(Sinus.isSelected())
    mh.getDiseaseList().add(Sinus.getText());
   
     if(HIV.isSelected())
    mh.getDiseaseList().add(HIV.getText());
     
     if(Cancer.isSelected())
    mh.getDiseaseList().add(Cancer.getText());
    
     if(HyperTension.isSelected())
    mh.getDiseaseList().add(HyperTension.getText());

      if(Amnesia.isSelected())
    mh.getDiseaseList().add(Amnesia.getText());

     
     if(other.isSelected())
    mh.getDiseaseList().add("other: "+other.getText());

     //////////////////Allergy////////////////////////
     if(Aspirin.isSelected())
    mh.getAllergyList().add(Aspirin.getText());
     
     if(Pencilin.isSelected())
    mh.getAllergyList().add(Pencilin.getText());

     if(Codeine.isSelected())
    mh.getAllergyList().add(Codeine.getText());

     if(LocalAnesthetics.isSelected())
    mh.getAllergyList().add(LocalAnesthetics.getText());

     if(Arcylic.isSelected())
    mh.getAllergyList().add(Arcylic.getText());

     if(Metal.isSelected())
    mh.getAllergyList().add(Metal.getText());

     if(Latex.isSelected())
    mh.getAllergyList().add(Latex.getText());
     if(pollenGrains.isSelected())
    mh.getAllergyList().add(pollenGrains.getText());
     if(UV.isSelected())
    mh.getAllergyList().add(UV.getText());

     if(otherAllergy.isSelected())
    mh.getAllergyList().add("other: "+otherAllergyTxt.getText());

     Questionnaire q=new Questionnaire();
        q.setQuestion("Alchohol Usage:");
        if(AlchoholY.isSelected())
        q.setStatus(true);
        
         if(AlchoholN.isSelected())
         q.setStatus(false);
        mh.getQuestionnaireList().add(q);
        
        q=new Questionnaire();
        q.setQuestion("Are you taking any medication, pills or drugs?");
        if(PreviousMediY.isSelected())
        {
            q.setStatus(true);
            q.setComment(PreviousMeditxt.getText());
        }
        
         if(PreviousMediN.isSelected())
         q.setStatus(false);
        mh.getQuestionnaireList().add(q);
        
        q=new Questionnaire();
        q.setQuestion("Have you ever been Hospitalized or had a major operation?");
        if(OperationY.isSelected())
        {
            q.setStatus(true);
            q.setComment(Operationtxt.getText());
        }
        
         if(OperationY.isSelected())
         q.setStatus(false);
        mh.getQuestionnaireList().add(q);

        q=new Questionnaire();
        q.setQuestion("Are you on a special diet?");
        if(dietY.isSelected())
        {
            q.setStatus(true);
            q.setComment(dietTxt.getText());
        }
        
         if(dietN.isSelected())
         q.setStatus(false);
        mh.getQuestionnaireList().add(q);
        
        if(Validation.textFieldEmpty(heightTxt) && Validation.textFieldEmpty(weightTxt))
        {
        mh.setHeight(Integer.parseInt(heightTxt.getText()));
        mh.setWeight(Integer.parseInt(weightTxt.getText()));
        ua.setMedicalHistory(mh);
         JOptionPane.showMessageDialog(null, "User detail saved successfully");
        userProcessContainer.removeAll();
        }
        else{
         JOptionPane.showMessageDialog(null, "Enter weight and height");
            
        }

    }
///////////////////////////Setting medical history///////////////////////////////////////////////////////
        else{
              JOptionPane.showMessageDialog(null, "Please complete all the questions of questionnaire");

            }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
                userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        // TODO add your handling code here:
                  userinterface.User.IssueRequestHistoryJPanel panel = new userinterface.User.IssueRequestHistoryJPanel(userProcessContainer, ua);
        userProcessContainer.add("IssueRequestHistoryJPanel", panel);
        ((CardLayout)userProcessContainer.getLayout()).next(userProcessContainer);
    }//GEN-LAST:event_btnBack2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AlchoholN;
    private javax.swing.JRadioButton AlchoholY;
    private javax.swing.JCheckBox Amnesia;
    private javax.swing.JCheckBox Arcylic;
    private javax.swing.JCheckBox Aspirin;
    private javax.swing.JCheckBox Asthama;
    private javax.swing.JCheckBox Cancer;
    private javax.swing.JCheckBox Codeine;
    private javax.swing.JCheckBox Diabetes;
    private javax.swing.JCheckBox HIV;
    private javax.swing.JCheckBox Hepatitis;
    private javax.swing.JCheckBox HighCholestrol;
    private javax.swing.JCheckBox HyperTension;
    private javax.swing.JCheckBox KidneyDisease;
    private javax.swing.JCheckBox Latex;
    private javax.swing.JCheckBox LiverDisease;
    private javax.swing.JCheckBox LocalAnesthetics;
    private javax.swing.JCheckBox Metal;
    private javax.swing.JRadioButton OperationN;
    private javax.swing.JRadioButton OperationY;
    private javax.swing.JTextField Operationtxt;
    private javax.swing.JCheckBox Pencilin;
    private javax.swing.JRadioButton PreviousMediN;
    private javax.swing.JRadioButton PreviousMediY;
    private javax.swing.JTextField PreviousMeditxt;
    private javax.swing.JCheckBox Sinus;
    private javax.swing.JCheckBox ThyroidProblem;
    private javax.swing.JCheckBox Tuberculosis;
    private javax.swing.JCheckBox UV;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JRadioButton dietN;
    private javax.swing.JTextField dietTxt;
    private javax.swing.JRadioButton dietY;
    private javax.swing.JTextField heightTxt;
    private javax.swing.JCheckBox highBloodPressure;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblCustomername10;
    private javax.swing.JLabel lblCustomername11;
    private javax.swing.JLabel lblCustomername4;
    private javax.swing.JLabel lblCustomername5;
    private javax.swing.JLabel lblCustomername6;
    private javax.swing.JLabel lblCustomername7;
    private javax.swing.JLabel lblCustomername8;
    private javax.swing.JLabel lblCustomername9;
    private javax.swing.JCheckBox lungDisease;
    private javax.swing.JCheckBox other;
    private javax.swing.JCheckBox otherAllergy;
    private javax.swing.JTextField otherAllergyTxt;
    private javax.swing.JTextField otherTxt;
    private javax.swing.JCheckBox pollenGrains;
    private javax.swing.JTextField weightTxt;
    // End of variables declaration//GEN-END:variables
}
