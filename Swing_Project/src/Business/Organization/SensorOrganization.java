/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.Role;
import Business.Role.SensorAdmin;
import Business.SensorValues.SensorValues;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class SensorOrganization extends Organization{

    private SensorValues sensorValues;
    
    public SensorOrganization() {
        super(Type.Admin.getValue());
    }

    public SensorValues getSensorValues() {
        return sensorValues;
    }

    public void setSensorValues(SensorValues sensorValues) {
        this.sensorValues = sensorValues;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SensorAdmin());
        return roles;
    }
     
}
