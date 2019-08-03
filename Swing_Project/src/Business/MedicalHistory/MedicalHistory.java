/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MedicalHistory;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class MedicalHistory {
    private ArrayList<String> allergyList;
    private ArrayList<String> diseaseList;
    private ArrayList<Questionnaire> questionnaireList;
    private int height;
    private int weight;

    public MedicalHistory() {
        allergyList=new ArrayList<String>();
        diseaseList=new ArrayList<String>();
        questionnaireList=new ArrayList<Questionnaire>();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    
    public ArrayList<String> getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(ArrayList<String> allergyList) {
        this.allergyList = allergyList;
    }

    public ArrayList<String> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(ArrayList<String> diseaseList) {
        this.diseaseList = diseaseList;
    }

    public ArrayList<Questionnaire> getQuestionnaireList() {
        return questionnaireList;
    }

    public void setQuestionnaireList(ArrayList<Questionnaire> questionnaireList) {
        this.questionnaireList = questionnaireList;
    }
    
    
}
