/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Appointment.Appointment;
import Business.Rating.UserRating;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {

    private ArrayList<Conversation> conversation;
    private ArrayList<LabTestWorkRequest> labTests;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private String title;
    private int id;
    private static int count=1;
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        WorkRequest.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public WorkRequest(){
        requestDate = new Date();
        conversation = new ArrayList<Conversation>();
        labTests = new ArrayList<>();
        id=count;
        count++;
        System.out.println(count);
    }

    public ArrayList<LabTestWorkRequest> getLabTests() {
        return labTests;
    }

    public void setLabTests(ArrayList<LabTestWorkRequest> labTests) {
        this.labTests = labTests;
    }

    public ArrayList<Conversation> getConversation() {
        return conversation;
    }

    public void setConversation(ArrayList<Conversation> conversation) {
        this.conversation = conversation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    @Override
    public String toString(){
        return String.valueOf(this.id);
    }
}
