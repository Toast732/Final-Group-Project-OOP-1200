package javaProject.methods.guiElements;

import javax.swing.*;
import java.awt.*;
import javaProject.methods.User;  // Ensure User class is imported

public class UserProfileGUI extends JFrame {
    private User user;  // Store the entire User object

    public UserProfileGUI(User user) {
        this.user = user;
        createUI();
    }

    private void createUI() {
        setTitle("User Profile - " + user.getUsername()); // Display username in the window title
        setSize(350, 400); // Adjusted size for additional information
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 1)); // Use GridLayout for better organization of labels

        // Display various user details
        add(new JLabel("Welcome, " + user.getName() + " " + user.getFamilyName()));
        add(new JLabel("Username: " + user.getUsername()));
        add(new JLabel("Email: " + user.getEmail()));

        setVisible(true);
    }
}
