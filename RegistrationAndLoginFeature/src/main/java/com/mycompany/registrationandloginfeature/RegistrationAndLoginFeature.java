/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationandloginfeature;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class RegistrationAndLoginFeature {

    static String storedUsername;
    static String storedPassword;
    static String storedPhone;
    static String firstName;
    static String lastName;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ================= REGISTRATION =================
        System.out.println("=== REGISTRATION ===");

        System.out.print("Enter First Name: ");
        firstName = input.nextLine();

        System.out.print("Enter Last Name: ");
        lastName = input.nextLine();

        System.out.print("Enter Username: ");
        storedUsername = input.nextLine();

        if (checkUsername(storedUsername)) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
        }

        System.out.print("Enter Password: ");
        storedPassword = input.nextLine();

        if (checkPassword(storedPassword)) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        }

        System.out.print("Enter SA Cell Phone (+27...): ");
        storedPhone = input.nextLine();

        if (checkCellPhoneNumber(storedPhone)) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
        }

        // ================= LOGIN =================
        System.out.println("\n=== LOGIN ===");

        System.out.print("Enter Username: ");
        String loginUser = input.nextLine();

        System.out.print("Enter Password: ");
        String loginPass = input.nextLine();

        loginUser(loginUser, loginPass);
    }

    // ================= METHODS =================

    // Username: must contain "_" and be <= 5 characters
    public static boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Password rules
    public static boolean checkPassword(String password) {
        boolean length = password.length() >= 8;
        boolean capital = password.matches(".*[A-Z].*");
        boolean number = password.matches(".*[0-9].*");
        boolean special = password.matches(".*[^a-zA-Z0-9].*");

        return length && capital && number && special;
    }

    // SA Phone: +27 followed by 9 digits
    public static boolean checkCellPhoneNumber(String phone) {
        return phone.matches("^\\+27\\d{8}$");
    }

    // Login validation
    public static void loginUser(String username, String password) {
        if (username.equals(storedUsername) && password.equals(storedPassword)) {
            System.out.println("Welcome " + firstName + ", " + lastName + " it is great to see you again.");
        } else {
            System.out.println("Username or password incorrect, please try again.");
        }
    }
}
