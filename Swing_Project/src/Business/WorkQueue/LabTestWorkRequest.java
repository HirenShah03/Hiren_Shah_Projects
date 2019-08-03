/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Results.Result;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Jigar
 */
public class LabTestWorkRequest extends WorkRequest{
    private ArrayList<Result> testResults;
    private UserAccount labAssigned;
    
    public LabTestWorkRequest() {
        testResults = new ArrayList<Result>();
        labAssigned = null;
    }

    public UserAccount getLabAssigned() {
        return labAssigned;
    }

    public void setLabAssigned(UserAccount labAssigned) {
        this.labAssigned = labAssigned;
    }

    public ArrayList<Result> getTestResults() {
        return testResults;
    }

    public void setTestResults(ArrayList<Result> testResults) {
        this.testResults = testResults;
    }
    
}
