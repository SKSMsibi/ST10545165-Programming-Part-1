/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part1;

/**
 *
 * @author Sandile Msibi ROG
 */
public class Login {
    public boolean checkUserName(String userName) 
    {
        //Check is the user name contain an under score and not more than five characters
    if (userName == null) {
        return false;
            
        }

        boolean containsUnderscore = userName.contains("_");
        boolean lengthValid = userName.length() <= 5;

        return containsUnderscore && lengthValid;
    }
    
    public boolean checkPasswordComplexity(String userPassword) 
    {
    // This method checks is the password meets the required compleexity rules.
        //The password must be: • At least eight characters long. • Contain a capital letter. • Contain a number. • Contain a special character.
       if (userPassword == null) {
        return false;
    }

    boolean hasMinLength = userPassword.length() >= 8;
    boolean hasCapital = false;
    boolean hasNumber = false;
    boolean hasSpecial = false;

    for (char c : userPassword.toCharArray()) {
        if (Character.isUpperCase(c)) {
            hasCapital = true;
        } else if (Character.isDigit(c)) {
            hasNumber = true;
        } else if (!Character.isLetterOrDigit(c)) {
            hasSpecial = true;
        }
    }

    return hasMinLength && hasCapital && hasNumber && hasSpecial;
    }
    
    public boolean checkCellPhoneNumber(String userCellphone)
    {
        //This method ensures that the cell phone is the correct length and contains the international country code.
   if (userCellphone == null) {
        return false;
    }

    boolean hasCountryCode = userCellphone.startsWith("+27");
    boolean hasCorrectLength = userCellphone.length() == 12;

    // Check if every character after the '+' is a number without plus. 
    boolean digitsOnly = true;
    for (int i = 1; i < userCellphone.length(); i++) {
        char c = userCellphone.charAt(i);
        if (!Character.isDigit(c)) {
            digitsOnly = false;
            break; 
        }
    }

    return hasCountryCode && hasCorrectLength && digitsOnly;
    }
    
    public String registerUser () 
    
    { 
        String registrationMessage;
        registrationMessage = "Sandile";
        return registrationMessage;
        
        
    }
    
    public boolean loginUser()
    
    {
    boolean result = false;
        return result;
    }
    
    public String returnLoginStatus()
    {
        String loginStatus;
        loginStatus = "Sandile";
        return loginStatus;
    }
    
    
}
