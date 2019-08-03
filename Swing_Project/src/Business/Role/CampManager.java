/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.CampManagerRole.CampManagerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class CampManager extends Role{
    
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new CampManagerWorkAreaJPanel(userProcessContainer, account, organization, business);
        //return null;
    }

    
}
