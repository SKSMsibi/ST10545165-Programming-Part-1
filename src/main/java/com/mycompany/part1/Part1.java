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
        runQuickChat(input);
        
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
    
    public static boolean userLogin(Scanner input, Login newUserObj)
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
       
        boolean loginResult = newUserObj.loginUser(userName, userPassword);
        System.out.println(newUserObj.returnLoginStatus(loginResult));
        
    return loginResult;
    }
    
    
    // PART 2: QUICK CHAT MENU & MESSAGE HANDLING
    
    public static void runQuickChat(Scanner input) {
        System.out.println("\nWelcome to QuickChat.");

        boolean running = true;
        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choice: ");

            String choiceStr = input.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                continue;
            }

            switch (choice) {
                case 1:
                    handleSendMessages(input);
                    break;
                case 2:
                    System.out.println("Coming Soon.");
                    break;
                case 3:
                    System.out.println("Goodbye");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
                    break;
            }
        }
    }

    public static void handleSendMessages(Scanner input) {
        System.out.print("\nHow many messages do you wish to enter? ");
        int totalMessagesToEnter;
        try {
            totalMessagesToEnter = Integer.parseInt(input.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Returning to main menu.");
            return;
        }

        for (int i = 0; i < totalMessagesToEnter; i++) {
            System.out.println("\n--- Message " + (i + 1) + " of " + totalMessagesToEnter + " ---");
            Message msg = new Message();
            msg.setMessageNumber(i);

            // Generate and print Message ID
            String generatedID = msg.generateMessageID();
            msg.setMessageID(generatedID);
            System.out.println("Message ID generated: " + generatedID);

            // Recipient validation loop
            String recipient;
            while (true) {
                System.out.print("Enter recipient cell number: ");
                recipient = input.nextLine();
                String validationResponse = msg.checkRecipientCell(recipient);
                System.out.println(validationResponse);
                if (validationResponse.equals("Cell phone number successfully captured.")) {
                    msg.setRecipientCell(recipient);
                    break;
                }
            }

            // Message text validation loop (<= 250 characters)
            String text;
            while (true) {
                System.out.print("Enter message content: ");
                text = input.nextLine();
                String lengthResponse = msg.checkMessageLength(text);
                if (lengthResponse.equals("Message ready to send.")) {
                    msg.setMessageText(text);
                    break;
                } else {
                    System.out.println(lengthResponse);
                }
            }

            // Create Hash
            msg.createMessageHash();

            // Choose Action (Send, Disregard, Store)
            System.out.println("\nChoose an option:");
            System.out.println("1) Send Message");
            System.out.println("2) Disregard Message");
            System.out.println("3) Store Message to send later");
            System.out.print("Selection: ");

            int actionChoice = 1;
            try {
                actionChoice = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Defaulting to Send.");
            }

            String actionResult = msg.sentMessage(actionChoice);
            System.out.println(actionResult);

            if (actionChoice == 1) {
                System.out.println("\n=== MESSAGE DETAILS ===");
                System.out.println("Message ID   : " + msg.getMessageID());
                System.out.println("Message Hash : " + msg.getMessageHash());
                System.out.println("Recipient    : " + msg.getRecipientCell());
                System.out.println("Message      : " + msg.getMessageText());
                System.out.println("=======================");
            }
        }

        // Display total messages sent after the loop completes
        System.out.println("\nTotal messages sent: " + Message.returnTotalMessages());
    }
}