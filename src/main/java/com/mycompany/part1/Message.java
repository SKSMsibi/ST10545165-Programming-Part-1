/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Sandile Msibi ROG
 */
public class Message {
    
    // --- CLASS DECLARATIONS ---
    private String messageID;
    private int messageNumber;
    private String recipientCell;
    private String messageText;
    private String messageHash;
    private static List<Message> sentMessagesList = new ArrayList<>();

    // Optional: Default constructor
    public Message() {
    }

    // Optional: Parameterized constructor to initialize values easily
    public Message(String messageID, int messageNumber, String recipientCell, String messageText) {
        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
    }

    // Getters for displaying data securely
    public String getMessageText() { return messageText; }
    public void setMessageText(String messageText) { this.messageText = messageText; }
    
    public String getMessageID() { return messageID; }
    public void setMessageID(String messageID) { this.messageID = messageID; }
    
    public String getRecipientCell() { return recipientCell; }
    public void setRecipientCell(String recipientCell) { this.recipientCell = recipientCell; }
    
    public String getMessageHash() { return messageHash; }
    
    public int getMessageNumber() { return messageNumber; }
    public void setMessageNumber(int messageNumber) { this.messageNumber = messageNumber; }

    //0
    public String generateMessageID() 
    {
        // This method generates a random 10-digit message ID
        Random rand = new Random();
        StringBuilder stringBuild = new StringBuilder();
        
        for (int i = 0; i < 10; i++) {
            stringBuild.append(rand.nextInt(10)); // Appends a random digit from 0 to 9, ten times
        }
        
        return stringBuild.toString();
    }
    
    //1
    public boolean checkMessageID(String messageID) 
    {
        // This method ensures that the message ID is not more than ten characters.
        if (messageID == null) {
            return false;
        }
        
        boolean lengthValid = messageID.length() <= 10;
        
        return lengthValid;
    }
    
    //2
    public String checkRecipientCell(String recipientCell) 
    {
        // This method ensures that the recipient cell number is no more than eleven characters long and starts with a country code.
        if (recipientCell == null) {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }

        boolean hasCountryCode = recipientCell.startsWith("27") || recipientCell.startsWith("+27");
        boolean hasCorrectLength = recipientCell.length() <= 11;

        boolean digitsOnly = true;
        int startIndex = recipientCell.startsWith("+") ? 1 : 0;
        
        for (int i = startIndex; i < recipientCell.length(); i++) {
            char c = recipientCell.charAt(i);
            if (!Character.isDigit(c)) {
                digitsOnly = false;
                break;
            }
        }

        if (hasCountryCode && hasCorrectLength && digitsOnly) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }
    
    // Added helper to match your main class call for <= 250 character check
    public String checkMessageLength(String message) {
        if (message == null) {
            return "Message ready to send.";
        }
        if (message.length() <= 250) {
            return "Message ready to send.";
        } else {
            int excess = message.length() - 250;
            return "Message exceeds 250 characters by " + excess + "; please reduce the size.";
        }
    }
    
    //3
    public String createMessageHash()
    {
        // This method creates and returns the Message Hash. 
        String idPrefix = "00";
        if (this.messageID != null) {
            idPrefix = this.messageID.substring(0, 2); // Truncates the last 8 digits, keeping the first 2
        }

        String firstWord = "";
        String lastWord = "";

        if (this.messageText != null && !this.messageText.trim().isEmpty()) {
            // Clean out punctuation to isolate words properly
            String cleaned = this.messageText.replaceAll("[^a-zA-Z0-9\\s]", " ").trim();
            String[] words = cleaned.split("\\s+");

            if (words.length > 0) {
                firstWord = words[0];
                lastWord = words[words.length - 1];
            }
        }

        String hash = (idPrefix + ":" + this.messageNumber + ":" + firstWord + lastWord).toUpperCase();
        this.messageHash = hash;
        return hash;
    }
    
    //4    
    public String sentMessage(int choice)
    {
        // This method allows the user to choose if they want to send, store, or disregard the message.
        switch (choice) {
            case 1:
                sentMessagesList.add(this);
                return "Message successfully sent.";
            case 2:
                return "Press 0 to delete the message.";
            case 3:
                storeMessage();
                return "Message successfully stored.";
            default:
                return "Invalid option selected.";
        }
    }
    
    //5
    public String printMessages()
    {
        // This method prints all messages depending on how many the user sent
        String allMessages = "";
        
        // Loop through the list based on the total number of messages sent
        for (int i = 0; i < sentMessagesList.size(); i++) {
            Message msg = sentMessagesList.get(i);
            
            // Build the text, numbering each message starting from 1
            allMessages += "Message " + (i + 1) + ": " + msg.getMessageText() + "\n";
        }
        
        return allMessages;
    }
    
    //6 (Aliased returnTotalMessages so it matches main class calls)
    public int returnAllMessages()
    {
        // This method returns the total number of messages sent. 
        return sentMessagesList.size();
    }
    
    public static int returnTotalMessages() {
        return sentMessagesList.size();
    }
    
    //7
    public boolean storeMessage()
    {
        // This message stores the messages in JSON
        String json = "{\n"
                + "  \"MessageID\": \"" + this.messageID + "\",\n"
                + "  \"MessageHash\": \"" + this.messageHash + "\",\n"
                + "  \"Recipient\": \"" + this.recipientCell + "\",\n"
                + "  \"Message\": \"" + this.messageText + "\"\n"
                + "},\n";

        try (java.io.FileWriter writer = new java.io.FileWriter("messages.json", true)) {
            writer.write(json);
            return true; // Successfully saved
        } catch (java.io.IOException e) {
            return false; // Failed to save
        }
    }
}