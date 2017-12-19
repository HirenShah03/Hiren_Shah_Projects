/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author HP
 */
public class PharmacistEnterprise extends Enterprise{
    
    private double longitude;
    private double latitude;

    public PharmacistEnterprise(String name) {
        super(name, EnterpriseType.Pharmacist);
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

}
