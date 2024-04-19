package javaProject.methods;

import java.io.*;
import java.util.*;
import javaProject.methods.FileIOManager;

public class Login {
    private Map<String, User> userDatabase = new HashMap<>();
    //old: private final String USERS_FILE = "users.txt";
    private final FileIOManager fileManager;

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
            return false;
        }
        User newUser = new User(username, password, name, familyName, email);
        userDatabase.put(username, newUser);
        String userData = String.join("|", username, password, name, familyName, email);
        try {
            fileManager.appendToFile(userData);
        } catch (IOException e) {
            System.out.println("Error saving user: " + e.getMessage());
            return false;
        }
        return true;
    }
    /*public boolean register(String username, String password, String name, String familyName, String email) {
        if (userDatabase.containsKey(username)) {
            return false; // User already exists
        }
        User newUser = new User(username, password, name, familyName, email);
        userDatabase.put(username, newUser);
        String userData = String.join("|", username, password, name, familyName, email);
        try {
            userStore(userData); // Append user data to the file
        } catch (IOException e) {
            System.out.println("Error saving user: " + e.getMessage());
            return false; // Return false if there is an error during saving
        }
        return true;
    } */


    private void loadUsers() {
        List<String> lines = fileManager.readFile();
        userDatabase.clear();
        for (String line : lines) {
            String[] userData = line.split("\\|");
            if (userData.length == 5) {
                try {
                    User user = new User(userData[0], userData[1], userData[2], userData[3], userData[4]);
                    userDatabase.put(userData[0], user);
                } catch (Exception e) {
                    System.out.println("Error retrieving user data: " + e.getMessage());
                }
            }
        }
    }

        /*File file = new File(USERS_FILE);
        if (!file.exists()) {
            return; // If the file doesn't exist, there's nothing to load
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                userDatabase.clear(); // Clears existing data, useful if reloading users
                while ((line = reader.readLine()) != null) {
                    String[] userData = line.split("\\|");
                    if (userData.length == 5) {
                        try {
                            User user = new User(userData[0], userData[1], userData[2], userData[3], userData[4]);
                            userDatabase.put(userData[0], user);
                        } catch (Exception e) {
                            System.out.println("Error getting user data for line: " + line + "; Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Incorrect data format for line: " + line);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error loading user database: " + e.getMessage());
            }
        }
    }

     private void userStore(String content) throws IOException {
        File profileInfo = new File(USERS_FILE);
        if (!profileInfo.exists()) {
            boolean created = profileInfo.createNewFile();
            if (!created) {
                throw new IOException("User info file called " + profileInfo + " cannot be made.");
            }
        }
        try (FileWriter fw = new FileWriter(profileInfo, true); // true to append
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(content); // Write the content to the file and move to a new line
        } catch (IOException e) {
            throw new IOException("Failed to write to " + "users.txt" + ": " + e.getMessage(), e);
        }
    } */
}
