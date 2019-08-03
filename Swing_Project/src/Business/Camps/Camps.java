/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Camps;


import Business.Organization.DoctorOrganization;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Madhuja
 */
public class Camps {
    private String campName;
    private String location;
    private Date date;
    private String description;
    private String contact;
    private ArrayList<UserAccount> doctorList;

    public Camps() {
        doctorList = new ArrayList<UserAccount>();
    }

    public String getCampName() {
        return campName;
    }

    public void setCampName(String campName) {
        this.campName = campName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public ArrayList<UserAccount> getDoctorList() {
        return doctorList;
    }    
    
    public UserAccount createDoctor(){
        UserAccount ua = new UserAccount();
        doctorList.add(ua);
        return ua;
    }
    
    @Override
    public String toString(){
       return this.getCampName();
    }
}
