/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.MedicalHistory.MedicalHistory;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author mhj
 */
 public class UserAccount {
    
    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private WorkQueue workQueue;
    private MedicalHistory medicalHistory;
    private double rating;
    private int ratedUserCount;
    
    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public UserAccount() {
        workQueue = new WorkQueue();
        medicalHistory=new MedicalHistory();
        ratedUserCount = 0;
        rating = 0.0;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getRatedUserCount() {
        return ratedUserCount;
    }

    public void setRatedUserCount(int ratedUserCount) {
        this.ratedUserCount = ratedUserCount;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    @Override
    public String toString() {
        return username;
    }
    
}