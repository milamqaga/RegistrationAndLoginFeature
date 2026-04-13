package com.mycompany.registrationandloginfeature;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegristrationAndLoginFeatureTest {

    Login login = new Login();

    // =========================================================
    // 1. assertTrue / assertFalse TESTS (From the POE Table)
    // =========================================================

    @Test
    public void testUsernameCorrectlyFormatted() {
        // Test Data: "kyl_1" -> Expected: True
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        // Test Data: "kyle!!!!!!!" -> Expected: False
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testPasswordMeetsComplexity() {
        // Test Data: "Ch&&sec@ke99!" -> Expected: True
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        // Test Data: "password" -> Expected: False
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCellPhoneCorrectlyFormatted() {
        // Test Data: "+27838968976" -> Expected: True
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        // Test Data: "08966553" -> Expected: False
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testLoginSuccessful() {
        // We must register the user first so the system knows them
        login.registerUser("Kamva", "Dyantyi", "kyl_1", "Ch&&sec@ke99!", "+27838968976");

        // Test Data: matching credentials -> Expected: True
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        // We register the user first
        login.registerUser("Kamva", "Dyantyi", "kyl_1", "Ch&&sec@ke99!", "+27838968976");

        // Test Data: wrong credentials -> Expected: False
        assertFalse(login.loginUser("wrongUser", "wrongPass"));
    }

    // =========================================================
    // 2. assertEquals TESTS (Verifying exact String output)
    // =========================================================

    @Test
    public void testReturnLoginStatusSuccessfulMessage() {
        // Register the user to set the first and last name in the system
        login.registerUser("Kamva", "Dyantyi", "kyl_1", "Ch&&sec@ke99!", "+27838968976");

        // The expected welcome message
        String expectedMessage = "Welcome Kamva, Dyantyi it is great to see you again.";

        // Call the method passing 'true' for a successful login
        String actualMessage = login.returnLoginStatus(true);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testReturnLoginStatusFailedMessage() {
        String expectedMessage = "Username or password incorrect, please try again.";

        // Call the method passing 'false' for a failed login
        String actualMessage = login.returnLoginStatus(false);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testRegisterUserSuccessMessage() {
        String expectedMessage = "The two above conditions have been met, and the user has been registered successfully.";

        // Pass perfectly formatted data to get the success string
        String actualMessage = login.registerUser("Kamva", "Dyantyi", "kyl_1", "Ch&&sec@ke99!", "+27838968976");

        assertEquals(expectedMessage, actualMessage);
    }
}
