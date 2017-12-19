/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Prescription {
    private int prescriptionID;
    private ArrayList<PrescriptionItems> prescriptionItems;
    private boolean prescribed;
    private static int count = 0;

    public Prescription()
    {
       prescriptionItems= new ArrayList<PrescriptionItems>();
       prescriptionID = ++count;
    }
    
    public int getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public boolean isPrescribed() {
        return prescribed;
    }

    public void setPrescribed(boolean prescribed) {
        this.prescribed = prescribed;
    }

    public ArrayList<PrescriptionItems> getPrescriptionItems() {
        if (prescriptionItems == null) {
            prescriptionItems = new ArrayList<PrescriptionItems>();
        }
        return prescriptionItems;
    }

    public void setPrescriptionItems(ArrayList<PrescriptionItems> prescriptionItems) {
        this.prescriptionItems = prescriptionItems;
    }
    
    public PrescriptionItems addPrescription()
    {
        PrescriptionItems p=new PrescriptionItems();
        prescriptionItems.add(p);
        return p;
    }
}