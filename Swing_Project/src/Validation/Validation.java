/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class Validation {
    public static boolean emailVal(String emailId)
    {
        Pattern pattern = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}");
        Matcher matcher = pattern.matcher(emailId.toUpperCase());

        if(matcher.matches())
        {
            return true;
        }
        
        return false;
    }
    public static boolean ageVal(int age)
    {
        if(age>0 && age<110)
        {
            return true;
        }
        return false;
    }    
    public static boolean textFieldEmpty(JTextField tx) {
        if (!(tx.getText().trim().equals(""))) {
            return true;
        }
        return false;
    }
}
