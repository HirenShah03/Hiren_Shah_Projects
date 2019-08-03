/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Alert.Alert;
import Business.Allergy.Allergy;
import Business.Epidemic.Epidemic;
import Business.Role.AdminRole;
import Business.Role.AlertAdmin;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class AlertOrganization extends Organization{

    private ArrayList<Allergy> allergyList;
    private ArrayList<Epidemic> epidemicList;
    
    public AlertOrganization() {
        super(Type.Admin.getValue());
        allergyList = new ArrayList<Allergy>();
        epidemicList = new ArrayList<Epidemic>();
    }
    

    public ArrayList<Allergy> getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(ArrayList<Allergy> allergyList) {
        this.allergyList = allergyList;
    }

    public ArrayList<Epidemic> getEpidemicList() {
        return epidemicList;
    }

    public void setEpidemicList(ArrayList<Epidemic> epidemicList) {
        this.epidemicList = epidemicList;
    }

    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AlertAdmin());
        return roles;
    }
     
}
