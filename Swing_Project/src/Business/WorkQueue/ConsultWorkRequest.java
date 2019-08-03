/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Jigar
 */
public class ConsultWorkRequest extends WorkRequest{
    private IssueWorkRequest iwr;

    public ConsultWorkRequest(IssueWorkRequest iwr) {
        this.iwr = iwr;
    }

    public IssueWorkRequest getIwr() {
        return iwr;
    }

    public void setIwr(IssueWorkRequest iwr) {
        this.iwr = iwr;
    }

}
