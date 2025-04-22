/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registerationapp;

import java.util.Scanner;

public class RegisterationApp {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        AuthSystem auth = new AuthSystem();
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== User Authentication System ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");

            String userChoice = inputScanner.nextLine();

            switch (userChoice) {
                case "1":
                    System.out.print("Enter username: ");
                    String enteredUsername = inputScanner.nextLine();

                    System.out.print("Enter password: ");
                    String enteredPassword = inputScanner.nextLine();

                    System.out.print("Enter phone number: ");
                    String enteredPhone = inputScanner.nextLine();

                    String registrationResult = auth.registerUser(enteredUsername, enteredPassword, enteredPhone);
                    System.out.println(registrationResult);
                    break;

                case "2":
                    System.out.print("Enter username: ");
                    String loginUsername = inputScanner.nextLine();

                    System.out.print("Enter password: ");
                    String loginPassword = inputScanner.nextLine();

                    String loginMessage = auth.getLoginStatus(loginUsername, loginPassword);
                    System.out.println(loginMessage);
                    break;

                case "3":
                    System.out.println("Exiting... Goodbye!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        inputScanner.close();
    }
}
