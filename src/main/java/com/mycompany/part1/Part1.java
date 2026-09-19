/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.part1;
import java.util.Scanner;
/**
 *
 * @author Sandile Msibi ROG
 */
public class Part1 extends Login {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Login newUserObj = new Login();
        userRegistration(input,newUserObj);
        userLogin(input,newUserObj);
        
    }
    
    public static void userRegistration(Scanner input, Login newUserObj)
    {
        //Scanner input = new Scanner(System.in);
        //Login newUserObj = new Login();
        
        System.out.println("Welcome Please Enter Your User Name: ");
        String userName = input.nextLine();
        
        // Check the user name
        newUserObj.checkUserName(userName);
        
        System.out.println("Please Enter Your Password: ");
        String userPassword = input.nextLine();
        
        //Check Password
        newUserObj.checkPasswordComplexity(userPassword);
        
        
        System.out.println("Please Enter Your Callphone: ");
        String userCellphone = input.nextLine();
        
        //Check Phone number
        newUserObj.checkCellPhoneNumber(userCellphone);
        
        
        //Register User
        System.out.println(newUserObj.registerUser(userName, userPassword));
        newUserObj.setRegistrationDetails(userName, userPassword);
        
    }
    
    public static void userLogin(Scanner input, Login newUserObj)
    {
        //Scanner input = new Scanner(System.in);
        //Login newUserObj = new Login();
        
        
        System.out.println("Welcome Please Enter Your User Name: ");
        String userName = input.nextLine();
        
        // Check the user name
        //newUserObj.checkUserName(userName);
        
        System.out.println("Please Enter Your Password: ");
        String userPassword = input.nextLine();
        
        //Check Password
        //newUserObj.checkPasswordComplexity(userPassword);
        
        newUserObj.loginUser(userName, userPassword);
       
        System.out.println(newUserObj.returnLoginStatus(newUserObj.loginUser(userName, userPassword)));
        
    }
    
}
