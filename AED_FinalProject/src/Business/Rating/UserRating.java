/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Rating;

import Business.Role.Doctor;
import Business.UserAccount.UserAccount;

/**
 *
 * @author Madhuja
 */
public class UserRating {
    
    private UserAccount doctor;
    private int rating;

    public UserRating() {
        doctor = new UserAccount();
    }

    public UserAccount getDoctor() {
        return doctor;
    }

    public void setDoctor(UserAccount doctor) {
        this.doctor = doctor;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
}
