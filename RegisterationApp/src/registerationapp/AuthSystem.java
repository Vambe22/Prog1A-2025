/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registerationapp;



import java.util.HashMap;
import java.util.regex.Pattern;

public class AuthSystem {

    private HashMap<String, String> credentials = new HashMap<>();
    private HashMap<String, String> phoneNumbers = new HashMap<>();

    public boolean isUsernameValid(String username) {
        return username != null && username.length() >= 4 && !credentials.containsKey(username);
    }

    public boolean isPasswordValid(String password) {
        return password != null && password.length() >= 6 && password.matches(".*\\d.*");
    }

    public boolean isPhoneValid(String phone) {
        return Pattern.matches("\\d{10}", phone);
    }

    public String registerUser(String username, String password, String phone) {
        if (!isUsernameValid(username)) {
            return "Username is invalid or already taken.";
        }
        if (!isPasswordValid(password)) {
            return "Password must be at least 6 characters and contain a number.";
        }
        if (!isPhoneValid(phone)) {
            return "Phone number must be a 10-digit number.";
        }

        credentials.put(username, password);
        phoneNumbers.put(username, phone);
        return "Registration successful.";
    }

    public boolean authenticateUser(String username, String password) {
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }

    public String getLoginStatus(String username, String password) {
        if (authenticateUser(username, password)) {
            return "Login successful. Welcome, " + username + "!";
        } else {
            return "Login failed. Check username or password.";
        }
    }
}

