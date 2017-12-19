/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MedicalHistory;

/**
 *
 * @author HP
 */
public class Questionnaire {
    private String question;
    private boolean status;
    private String comment;

    public String getQuestion() {
        return question;
    }
    public boolean getStatus() {
        return status;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}
