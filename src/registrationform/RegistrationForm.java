/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrationform;

/**
 *
 * @author hardikkana
 */


import java.util.Scanner;

public class RegistrationForm {  // Class to handle user registration and login
    String usernameInput;  // Stores the entered username
    String passwordInput;  // Stores the entered password
    String firstName;      // Stores the user's first name
    String lastName;       // Stores the user's last name
    String loginUsername;  // Stores the username entered during login
    String loginPassword;  // Stores the password entered during login
    Scanner scanner = new Scanner(System.in);  // Scanner for user input

    // Method to check if the username is valid (must contain an underscore and be no more than 5 characters)
    public boolean checkUsername() {
        boolean validUsername = false;
        for (int i = 0; i < usernameInput.length(); i++) {
            if (usernameInput.length() <= 5 && usernameInput.contains("_")) {
                validUsername = true;
            }
        }
        return validUsername;
    }

    // Method to check if the password meets complexity requirements
    // The password must contain at least one uppercase letter, one number, and one special character
    public boolean checkPasswordComplexity() {
        boolean hasNumber = false;
        boolean hasSpecial = false;
        boolean hasLetter = false;

        for (int i = 0; i < passwordInput.length(); i++) {
            if (passwordInput.length() >= 8) {
                char ch = passwordInput.charAt(i);
                if (Character.isUpperCase(ch)) {
                    hasLetter = true;
                }
                if (Character.isDigit(ch)) {
                    hasNumber = true;
                }
                if (!Character.isLetterOrDigit(ch)) {
                    hasSpecial = true;
                }
            }
        }
        return hasLetter && hasNumber && hasSpecial;
    }

    // Method to handle the user registration process
    public String registerUser() {
        boolean validUsername = false;
        boolean validPassword = false;

        // Prompt for username and password until valid inputs are received
        while (!validUsername || !validPassword) {
            if (checkUsername()) {
                System.out.println("Username successfully captured");
                validUsername = true;
            } else {
                System.out.println("Invalid username. Ensure it contains an underscore and is no more than 5 characters.");
                System.out.println("Enter your username again:");
                usernameInput = scanner.next();
            }

            if (checkPasswordComplexity()) {
                System.out.println("Password successfully captured");
                validPassword = true;
            } else {
                System.out.println("Invalid password. Ensure it has at least 8 characters, a capital letter, a number, and a special character.");
                System.out.println("Enter your password again:");
                passwordInput = scanner.next();
            }
        }

        System.out.println("The username and password meet the complexity requirements. User registered successfully.");
        return "User registered successfully.";
    }

    // Method to verify login credentials
    public boolean loginUser() {
        return loginUsername.equals(usernameInput) && loginPassword.equals(passwordInput);
    }

    // Method to display login status
    public String returnLoginStatus() {
        if (loginUser()) {
            System.out.println("Successful Login");
            System.out.println("Welcome " + firstName + " " + lastName + "! It is great to see you again.");
        } else {
            System.out.println("Failed Login. Username or Password incorrect.");
        }
        return "";
    }

    public static void main(String[] args) {
        RegistrationForm account = new RegistrationForm();
        boolean loggedIn = false;

        // Capture user registration details
        System.out.println("Enter your username:");
        account.usernameInput = account.scanner.next();
        System.out.println("Enter your password:");
        account.passwordInput = account.scanner.next();
        System.out.println("Enter your first name:");
        account.firstName = account.scanner.next();
        System.out.println("Enter your last name:");
        account.lastName = account.scanner.next();
        System.out.println(account.registerUser());

        // Handle login process
        if (account.checkUsername() && account.checkPasswordComplexity()) {
            while (!loggedIn) {
                System.out.println("Enter your username for login:");
                account.loginUsername = account.scanner.next();
                System.out.println("Enter your password for login:");
                account.loginPassword = account.scanner.next();
                if (account.loginUser()) {
                    System.out.println(account.returnLoginStatus());
                    loggedIn = true;
                } else {
                    System.out.println("Failed Login. Username or Password incorrect.");
                }
            }
        }
    }
}
