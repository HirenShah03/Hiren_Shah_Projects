package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.Role.UserRole;
import Business.UserAccount.UserAccount;
import Business.Users.User;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        Employee employee = system.getEmployeeDirectory().createEmployee("RRH");
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        User user = system.getUserDir().createAndAddUser();
        Employee e = user.getEmployeeDirectory().createEmployee("mhj");
        UserAccount u = user.getUserAccountDirectory().createUserAccount("mhj", "mhj", e, new UserRole());
        system.getUserAccountDirectory().getUserAccountList().add(u);
        return system;
    }
    
}
