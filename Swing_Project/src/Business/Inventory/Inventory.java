/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Inventory;

import Business.Medicines.Medicine;
import java.util.ArrayList;

/**
 *
 * @author Madhuja
 */
public class Inventory {
    
    private Medicine medicine;
    private int quantity;

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    @Override
    public String toString()
    {
        return this.medicine.toString();
    }
}
