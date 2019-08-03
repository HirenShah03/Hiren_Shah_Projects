/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Rating.UserRating;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Jigar
 */
public class IssueWorkRequest extends WorkRequest{
 
    private Prescription prescription;
    private UserAccount doctorAssigned;
    private UserAccount issueRaiser;
    private ArrayList<UserRating> rating;
    private ArrayList<LabTestWorkRequest> labTests;

    public IssueWorkRequest() {
        prescription = new Prescription();
        doctorAssigned = new UserAccount();
        issueRaiser = new UserAccount();
        rating = new ArrayList<UserRating>();
        labTests = new ArrayList<LabTestWorkRequest>();
    }

    public ArrayList<LabTestWorkRequest> getLabTests() {
        return labTests;
    }

    public void setLabTests(ArrayList<LabTestWorkRequest> labTests) {
        this.labTests = labTests;
    }
    
    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public UserAccount getDoctorAssigned() {
        return doctorAssigned;
    }

    public void setDoctorAssigned(UserAccount doctorAssigned) {
        this.doctorAssigned = doctorAssigned;
    }

    public UserAccount getIssueRaiser() {
        return issueRaiser;
    }

    public void setIssueRaiser(UserAccount issueRaiser) {
        this.issueRaiser = issueRaiser;
    }

    public ArrayList<UserRating> getRating() {
        return rating;
    }

    public void setRating(ArrayList<UserRating> rating) {
        this.rating = rating;
    }
    
    
    
    
    public void updateRatingDoctorList(){
        for(Conversation c : this.getConversation()){
            if(c.getUa()!=this.issueRaiser){
                boolean avail = false;
                if(!this.rating.isEmpty()){
                    for(UserRating r : this.rating){
                        if(r.getDoctor()==c.getUa()){
                            avail = true;
                            break;
                        }
                    }
                }
                if(!avail){
                    UserRating drate = new UserRating();
                    drate.setDoctor(c.getUa());
                    this.rating.add(drate);
                }
            }
        }
    }
}
