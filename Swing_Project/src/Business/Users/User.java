/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Users;

import Business.MedicalHistory.MedicalHistory;
import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author kothari
 */
public class User extends Organization {
//    private MedicalHistory medicalHistory;
    public User() {
        super(null);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public MedicalHistory getMedicalHistory() {
//        return medicalHistory;
//    }
//
//    public void setMedicalHistory(MedicalHistory medicalHistory) {
//        this.medicalHistory = medicalHistory;
//    }
    
}
