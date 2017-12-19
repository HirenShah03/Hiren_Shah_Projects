/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Camps.Camps;
import Business.Role.AdminRole;
import Business.Role.CampManager;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class CampOrganization extends Organization{
private ArrayList<Camps> campsList;
    public CampOrganization() {
        super(Type.Camp.getValue());
        campsList = new ArrayList<>();  
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CampManager());
        return roles;
    }
     public ArrayList<Camps> getCampsList() {
        return campsList;
    }
    public Camps createCamp(Camps c){
        if(!campsList.contains(c)){
            campsList.add(c);
        }
        return c;
    }
}
