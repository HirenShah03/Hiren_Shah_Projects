/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Users;

import java.util.ArrayList;

/**
 *
 * @author kothari
 */
public class UserDirectory {
    private ArrayList<User> userDir;

    public UserDirectory() {
        userDir = new ArrayList<User>();
    }

    public ArrayList<User> getUserDir() {
        return userDir;
    }
    
    public User createAndAddUser() {
        User user = new User();
        userDir.add(user);
        return user;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (User ua : userDir){
            if (ua.equals(username))
                return false;
        }
        return true;
    }
    
}
