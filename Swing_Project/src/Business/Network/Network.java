/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import java.util.Random;

/**
 *
 * @author madhuja
 */
public class Network{
   
    private String country;
    private String state;
    private String city;
    private double longitude;
    private double latitude;
    private EnterpriseDirectory enterpriseDirectory;

    public Network() {
        Random r = new Random();
        enterpriseDirectory = new EnterpriseDirectory();
        longitude = r.nextDouble();
        latitude = r.nextDouble();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    @Override
    public String toString() {
        return city;
    }

   
}
