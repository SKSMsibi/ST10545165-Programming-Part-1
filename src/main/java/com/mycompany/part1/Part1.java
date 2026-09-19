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
        
        //Login User
        
        System.out.println(userName);
        System.out.println(userPassword);
        System.out.println(userCellphone); 
        
    }
    
}
