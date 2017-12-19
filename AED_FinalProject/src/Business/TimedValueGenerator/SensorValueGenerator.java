/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TimedValueGenerator;

import Business.Allergy.Allergy;
import Business.EcoSystem;
import Business.Enterprise.AlertEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.SensorEnterprise;
import Business.Network.Network;
import Business.Organization.AlertOrganization;
import Business.Organization.Organization;
import Business.Organization.SensorOrganization;
import Business.SensorValues.SensorValues;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author kothari
 */
public class SensorValueGenerator {

    
    public static void generator(final EcoSystem system) {
        Timer time = new Timer(); // Instantiate Timer Object
        TimerTask st = new TimerTask() {
        @Override
            public void run() {
                generateValues(system);
            }
        }; // Instantiate SheduledTask class
        time.schedule(st, 0, 1000); // Create Repetitively task for every 1 secs
//        try {
//            Thread.sleep(100000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(SensorValueGenerator.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    public static void generateValues(EcoSystem system){
        System.out.println(system);
        if(!system.getNetworkList().isEmpty()){
//            System.out.println(1);
            for(Network n : system.getNetworkList()){
//                System.out.println(2);
                for(Enterprise ent : n.getEnterpriseDirectory().getEnterpriseList()){
//                    System.out.println(3);
                    if(ent instanceof SensorEnterprise){
//                        System.out.println(4);
                        for(Organization org : ent.getOrganizationDirectory().getOrganizationList()){
//                            System.out.println(5);
                            if(org instanceof SensorOrganization){
                               SensorValues sensorValues= new SensorValues();
                                ((SensorOrganization)org).setSensorValues(sensorValues);
                                generateAlerts(system,sensorValues,n);
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static void generateAlerts(EcoSystem system,SensorValues sensorValues,Network n)
    {
        System.out.println(2);
        for(Enterprise ent : n.getEnterpriseDirectory().getEnterpriseList()){
            System.out.println(3);
            if(ent instanceof AlertEnterprise){
                System.out.println(4);
                for(Organization org : ent.getOrganizationDirectory().getOrganizationList()){
                    System.out.println(5);
                    if(org instanceof AlertOrganization){
                        ((AlertOrganization) org).setAllergyList(new ArrayList<Allergy>());
                        for(Allergy a:system.getAllergyList())
                        {
                            if(a.getSensorParameter().equalsIgnoreCase("pollen grains"))
                            {
                                if(sensorValues.getPollenRatio()>a.getThreshold())
                                {
                                    ((AlertOrganization)org).getAllergyList().add(a);
                                System.out.println("Pollen = "+sensorValues.getPollenRatio());
                                }
                            }

                            if(a.getSensorParameter().equalsIgnoreCase("UV Index"))
                            {
                               if(sensorValues.getUvIndex()>a.getThreshold())
                               {
                                   ((AlertOrganization)org).getAllergyList().add(a);

                                System.out.println("UV = "+sensorValues.getUvIndex());
                               }
                            }
                            if(a.getSensorParameter().equalsIgnoreCase("dander"))
                            {
                               if(sensorValues.getDander()>a.getThreshold())
                               {
                                   ((AlertOrganization)org).getAllergyList().add(a);

                                System.out.println("dander = "+sensorValues.getDander());
                               }
                            }
                            if(a.getSensorParameter().equalsIgnoreCase("dust mites"))
                            {
                               if(sensorValues.getDustmites()>a.getThreshold())
                               {
                                   ((AlertOrganization)org).getAllergyList().add(a);

                                System.out.println("dust = "+sensorValues.getDustmites());
                               }
                            }
                        }
                    }
                }
            }
        }
    }
}
