/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Sandile Msibi ROG
 */
public class MessageTest {

    private Message message;

    @BeforeEach
    public void setUp() {
        message = new Message();
    }

    @Test
    public void testMessageLengthSuccess() {
        String validMessage = "Hi Mike, can you join us for dinner tonight?";
        String expected = "Message ready to send.";
        String actual = message.checkMessageLength(validMessage);
        assertEquals(expected, actual);
    }

    @Test
    public void testMessageLengthFailure() {
        StringBuilder longMessage = new StringBuilder();
        for (int i = 0; i < 260; i++) {
            longMessage.append("A");
        }
        String expected = "Message exceeds 250 characters by 10; please reduce the size.";
        String actual = message.checkMessageLength(longMessage.toString());
        assertEquals(expected, actual);
    }

   @Test
    public void testRecipientCellSuccess() {
        String validNumber = "+27718693002";
        String expected = "Cell phone number successfully captured.";
        String actual = message.checkRecipientCell(validNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void testRecipientCellFailure() {
        String invalidNumber = "08575975889";
        String expected = "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        String actual = message.checkRecipientCell(invalidNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void testCreateMessageHashTestCase1() {
        message.setMessageID("0018693002");
        message.setMessageNumber(0);
        message.setMessageText("Hi Mike, can you join us for dinner tonight?");

        String actualHash = message.createMessageHash();
        assertEquals("00:0:HITONIGHT", actualHash);
    }

    @Test
    public void testMessageIDCreation() {
        String generatedId = message.generateMessageID();
        assertNotNull(generatedId);
        assertTrue(message.checkMessageID(generatedId));
    }

    @Test
    public void testSentMessageSendOption() {
        String result = message.sentMessage(1); // Fixed to lowercase s
        assertEquals("Message successfully sent.", result);
    }

    @Test
    public void testSentMessageDisregardOption() {
        String result = message.sentMessage(2); // Fixed to lowercase s
        assertEquals("Press 0 to delete the message.", result);
    }

    @Test
    public void testSentMessageStoreOption() {
        String result = message.sentMessage(3); // Fixed to lowercase s
        assertEquals("Message successfully stored.", result);
    }
    
    // Part 3 TESTSSSS 
    @Test
    public void testLongestStoredMessage() {
        // Test Data matching specification
        Message m1 = new Message("001", 1, "+27834557896", "Did you get the cake?");
        Message m2 = new Message("002", 2, "+27838884567", "Where are you? You are late! I have asked you to be on time.");
        
        // Populate test environment
        m1.classifyAndStore(1);
        m2.classifyAndStore(3);
        
        String longest = Message.getLongestStoredMessage();
        assertEquals("Where are you? You are late! I have asked you to be on time.", longest);
    }

    @Test
    public void testSearchByRecipient() {
        Message m2 = new Message("002", 2, "+27838884567", "Where are you? You are late! I have asked you to be on time.");
        Message m5 = new Message("005", 5, "+27838884567", "Ok, I am leaving without you.");
        m2.classifyAndStore(3);
        m5.classifyAndStore(3);

        String results = Message.searchByRecipient("+27838884567");
        assertTrue(results.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(results.contains("Ok, I am leaving without you."));
    }

    @Test
    public void testDeleteMessageByHash() {
        Message m2 = new Message("002", 2, "+27838884567", "Where are you? You are late! I have asked you to be on time.");
        m2.createMessageHash();
        m2.classifyAndStore(3);
        
        String hash = m2.getMessageHash();
        boolean deleted = Message.deleteMessageByHash(hash);
        assertTrue(deleted, "Message should be successfully deleted by hash.");
    }
}