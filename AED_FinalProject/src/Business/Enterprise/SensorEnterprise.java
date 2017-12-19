/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class SensorEnterprise extends Enterprise{
    
            public SensorEnterprise(String name) {
        super(name, EnterpriseType.Sensor);
    }


    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

}
