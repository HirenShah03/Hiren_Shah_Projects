package Business;

import Business.Allergy.Allergy;
import Business.Medicines.Medicine;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;
import Business.Users.UserDirectory;
import Business.Role.Role;
/**
 *
 * @author Administrator
 */
public class EcoSystem extends Organization {

    private static EcoSystem system;
    private ArrayList<Network> networkList;
    private UserDirectory userDir;
    private ArrayList<Medicine> medicineList;
    private ArrayList<Allergy> allergyList;

    public ArrayList<Medicine> getMedicineList() {
        return medicineList;
    }

    public UserDirectory getUserDir() {
        return userDir;
    }

    public void setUserDir(UserDirectory userDir) {
        this.userDir = userDir;
    }

    public static EcoSystem getInstance() {
        if (system == null) {
            system = new EcoSystem();
        }
        return system;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
        userDir = new UserDirectory();
        medicineList = new ArrayList<Medicine>();
        allergyList = new ArrayList<Allergy>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public ArrayList<Allergy> getAllergyList() {
        return allergyList;
    }
    
    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    @Override
        public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public boolean checkIfUsernameIsUnique(String username) {
        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }
        return true;
    }
    
}