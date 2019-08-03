/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Allergy;

/**
 *
 * @author Madhuja
 */
public class Allergy {
    private String allergy_by;
    private String symptoms;
    private String precautions;
    private String remedy;
    private String sensorParameter;
    private double threshold;

    public String getSensorParameter() {
        return sensorParameter;
    }

    public void setSensorParameter(String sensorParameter) {
        this.sensorParameter = sensorParameter;
    }


    
    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }
    
    
    public String getAllergy_by() {
        return allergy_by;
    }

    public void setAllergy_by(String allergy_by) {
        this.allergy_by = allergy_by;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    public String getRemedy() {
        return remedy;
    }

    public void setRemedy(String remedy) {
        this.remedy = remedy;
    }
    
    @Override
    public String toString(){
//        return this.allergy_by+", Symptoms : "+this.symptoms+", Precautions : "+this.precautions+", Remedies : "+this.remedy;
        return this.allergy_by;
    }
    
}
