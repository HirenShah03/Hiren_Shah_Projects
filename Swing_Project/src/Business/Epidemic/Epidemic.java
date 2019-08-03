/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Epidemic;

/**
 *
 * @author Jigar
 */
public class Epidemic {
    private String epidemicOf;
    private String precautions;
    private String vaccinations;

    public String getEpidemicOf() {
        return epidemicOf;
    }

    public void setEpidemicOf(String epidemicOf) {
        this.epidemicOf = epidemicOf;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    public String getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(String vaccinations) {
        this.vaccinations = vaccinations;
    }
    
    @Override
    public String toString(){
        return this.epidemicOf;
    }
    
}
