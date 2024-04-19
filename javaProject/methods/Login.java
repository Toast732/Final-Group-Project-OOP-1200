package javaProject.methods;

import java.io.*;
import java.util.*;

//Authentication of login and registration
public class Login {
    private Map<String, User> userDatabase = new HashMap<>(); //Database for storing user details
    private final FileIOManager fileManager; //File manager instance for the FileIO

    //Constructor to get the file manager here and load users
    public Login() {
        fileManager = new FileIOManager("users.txt");
        loadUsers();
    }

    public User getUser(String username) {
        return userDatabase.get(username);
    }

    public boolean authorizePass(String username, String password) {
        User user = userDatabase.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public boolean register(String username, String password, String name, String familyName, String email) {
        if (userDatabase.containsKey(username)) {
            return false; //If user already exists, don't reg
        }
        User newUser = new User(username, password, name, familyName, email);
        userDatabase.put(username, newUser);
        String userData = String.join("|", username, password, name, familyName, email);
        try {
            fileManager.appendToFile(userData); // Append to user file the new user so we don't overwrite who is there already
        } catch (IOException e) {
            System.out.println("Error saving user: " + e.getMessage());
            return false;
        }
        return true;
    }

    // Used to load user data from the file and put it into the user database we made earlier
    private void loadUsers() {
        List<String> lines = fileManager.readFile();
        userDatabase.clear(); // Clear current data before loading new data
        for (String line : lines) {
            String[] userData = line.split("\\|"); // Uses the | to tell when to split
            if (userData.length == 5) {
                try {
                    User user = new User(userData[0], userData[1], userData[2], userData[3], userData[4]);
                    userDatabase.put(userData[0], user); //Populate the user database
                } catch (Exception e) {
                    System.out.println("Error retrieving user data: " + e.getMessage());
                }
            }
        }
    }
}
