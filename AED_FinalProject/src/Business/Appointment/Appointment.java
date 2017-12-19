/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author kothari
 */
public class Appointment {
    
    private int appointmentId;
    private Date schedule;
    private UserAccount doctor;
    private UserAccount user;
    
    public Appointment() {
        doctor = new UserAccount();
        user = new UserAccount();
    }
    
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    
    public UserAccount getDoctor() {
        return doctor;
    }

    public void setDoctor(UserAccount doctor) {
        this.doctor = doctor;
    }

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }

}
