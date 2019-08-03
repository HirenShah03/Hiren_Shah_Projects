/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Inventory.Inventory;
import Business.Role.AdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class InventoryManager extends Organization{

    private ArrayList<Inventory> inventoryList;
    
    public InventoryManager() {
        super(Type.Inventory.getValue());
        inventoryList = new ArrayList<Inventory>();
    }
    
    public ArrayList<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }
   
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Business.Role.InventoryManager());
        return roles;
    }
}
