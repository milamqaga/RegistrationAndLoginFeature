package com.mycompany.registrationandloginfeature;
import java.util.Scanner;

public class RegistrationAndLoginFeature {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Login login = new Login(); // Using our new Login child class
            
            System.out.println("=== REGISTRATION ===");
            
            System.out.print("Enter First Name: ");
            String fName = input.nextLine();
            
            System.out.print("Enter Last Name: ");
            String lName = input.nextLine();
            
            System.out.print("Enter Username: ");
            String user = input.nextLine();
            
            System.out.print("Enter Password: ");
            String pass = input.nextLine();
            
            System.out.print("Enter SA Cell Phone (+27...): ");
            String phone = input.nextLine();
            
            // Call the registerUser method to do all checks at once
            String registrationMessage = login.registerUser(fName, lName, user, pass, phone);
            System.out.println(registrationMessage);
            
            // Only proceed to login if registration was successful
            if (registrationMessage.contains("successfully")) {
                System.out.println("\n=== LOGIN ===");
                System.out.print("Enter Username: ");
                String loginUser = input.nextLine();
                
                System.out.print("Enter Password: ");
                String loginPass = input.nextLine();
                
                boolean isLoggedIn = login.loginUser(loginUser, loginPass);
                System.out.println(login.returnLoginStatus(isLoggedIn));
            }
        } // Using our new Login child class
    }
}