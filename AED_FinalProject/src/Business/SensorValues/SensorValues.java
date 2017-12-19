/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SensorValues;

import java.util.Random;

/**
 *
 * @author kothari
 */
public class SensorValues {
    
    private double temperature;
    private double windSpeed;
    private int airQuality;
    private double humidity;
    private double pollenRatio;
    private int uvIndex;
    private int dustmites;
    private int dander;
    
    public SensorValues() {
        Random r = new Random();
        this.temperature = r.nextInt(32)+30;
        this.windSpeed = r.nextInt(35);
        this.airQuality = r.nextInt(10);
        this.humidity = r.nextInt(40)+40;
        this.pollenRatio = r.nextInt(50)+50;
        this.dustmites = r.nextInt(50)+50;
        this.dander = r.nextInt(50)+50;
        this.uvIndex = r.nextInt(10);
    }

    public int getDustmites() {
        return dustmites;
    }

    public void setDustmites(int dustmites) {
        this.dustmites = dustmites;
    }

    public int getDander() {
        return dander;
    }

    public void setDander(int dander) {
        this.dander = dander;
    }
    
    public double getTemperature() {
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public int getAirQuality() {
        return airQuality;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPollenRatio() {
        return pollenRatio;
    }

    public int getUvIndex() {
        return uvIndex;
    }

}
