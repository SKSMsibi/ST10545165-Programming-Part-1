package com.mycompany.part1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Sandile Msibi ROG
 */
public class LoginTest {
    
    Login login = new Login();

    @Test
    public void testCheckUserNameCorrect() {
        boolean actual = login.checkUserName("kyl_1");
        assertTrue(actual);
    }

    @Test
    public void testCheckUserNameIncorrect() {
        boolean actual = login.checkUserName("kyle!!!!!!");
        assertFalse(actual);
    }

    @Test
    public void testCheckPasswordComplexitySuccess() {
        boolean actual = login.checkPasswordComplexity("Ch&&sec@ke99!");
        assertTrue(actual);
    }

    @Test
    public void testCheckPasswordComplexityFailure() {
        boolean actual = login.checkPasswordComplexity("password");
        assertFalse(actual);
    }

    @Test
    public void testCheckCellPhoneNumberCorrect() {
        boolean actual = login.checkCellPhoneNumber("+27838968976");
        assertTrue(actual);
    }

    @Test
    public void testCheckCellPhoneNumberIncorrect() {
        boolean actual = login.checkCellPhoneNumber("08966553");
        assertFalse(actual);
    }

    @Test
    public void testLoginUserSuccess() {
        login.setRegistrationDetails("kyl_1", "Ch&&sec@ke99!");
        boolean actual = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue(actual);
    }

    @Test
    public void testLoginUserFailure() {
        login.setRegistrationDetails("kyl_1", "Ch&&sec@ke99!");
        boolean actual = login.loginUser("kyl_1", "WrongPassword1!");
        assertFalse(actual);
    }

    @Test
    public void testRegisterUserUsernameFailureMessage() {
        String expected = "The username is incorrectly formatted.";
        String actual = login.registerUser("kyle!!!!!!", "Ch&&sec@ke99!");
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterUserPasswordFailureMessage() {
        String expected = "The password does not meet the complexity requirements.";
        String actual = login.registerUser("kyl_1", "password");
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterUserSuccessMessage() {
        String expected = "The user has been registered successfully.";
        String actual = login.registerUser("kyl_1", "Ch&&sec@ke99!");
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnLoginStatusSuccessMessage() {
        String expected = "A successful login!";
        String actual = login.returnLoginStatus(true);
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnLoginStatusFailureMessage() {
        String expected = "A failed login! Username or password incorrect, please try again.";
        String actual = login.returnLoginStatus(false);
        assertEquals(expected, actual);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
