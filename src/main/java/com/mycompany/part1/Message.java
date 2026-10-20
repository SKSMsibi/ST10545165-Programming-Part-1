/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part1;

/**
 *
 * @author Sandile Msibi ROG
 */
public class Message {
    
    public boolean checkMessageID() 
    {
        //This method ensures that the message ID is not more than ten characters. 
        
        return false;
    }
    
    public String checkRecipientCell()  
    { 
        //This method ensures that the recipient cell number is no more than ten characters long and starts with a code. 
        String recipientCell = "Hey! Cell number here";
        return recipientCell;
    }
    
    public String createMessageHash()
    {
        //This method creates and returns the Message Hash. 
        String hash = "Hey! Hash here...";
        return hash;
    }
        
    public String sentMessage()
    {
        //This method should allow the user to choose if they want to send, store, or disregard the message. 
        String message = "Hi there!";
        return message;
    }
    
    public String printMessages()
    {
        //This method returns all the messages sent while the program is running. 
        String print = "Print stuff..";
        return print;
    }
    
    public int returnAllMessages()
    {
        //This method returns the total number of messages sent. 
        int messagecount = 1;
        return messagecount;
    }
    
    public boolean storeMessage()
    {
        //This message stores the messages in JSon
        return false;
    }
    
}
