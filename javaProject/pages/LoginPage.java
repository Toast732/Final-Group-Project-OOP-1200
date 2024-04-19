package javaProject.pages;

import javaProject.accounts.users.UserHandler;
import javaProject.customLayouts.GridBagVerticalList;
import javaProject.methods.Login;
import javaProject.pageSegments.KnownUserSegment;
import javaProject.pageSegments.PopupSegment;
import javaProject.window.BankWindow;
import javaProject.window.WindowHandler;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends NormalPage {

    public LoginPage() {
        // Create the page for this, and call it "Login"
        super("Login");

        // Create a 2x2 grid panel for the username and password.
        JPanel inputGridPanel = new JPanel(new GridLayout(2, 2));

        this.jPanel.add(inputGridPanel);

        // Create the vertical list.
        GridBagVerticalList verticalList = new GridBagVerticalList(this.jPanel);

        // Create the Username field.
        JTextField userNameField = new JTextField(32);

        // Create the Username label.
        JLabel usernameLabel = new JLabel("Username:");

        // Create the username JPanel.
        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // Add the label to the layout.
        usernamePanel.add(usernameLabel);

        // Create the Password field.
        JPasswordField passwordField = new JPasswordField(32);

        // Create the password JPanel.
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        // Add the label to the layout.
        passwordPanel.add(new JLabel("Password:"));

        inputGridPanel.add(usernamePanel);
        inputGridPanel.add(userNameField);
        inputGridPanel.add(passwordPanel);
        inputGridPanel.add(passwordField);

        // Create the Login button.
        JButton loginButton = new JButton("Login");

        // Add the fields to the panel.
        verticalList.add(inputGridPanel);
        verticalList.add(loginButton);

        loginButton.addActionListener(e -> {
            // Get the username and password.
            String username = userNameField.getText();
            String password = new String(passwordField.getPassword());

            // Attempt to log in.
            Login login = new Login();

            // Check if the login was successful.
            boolean success = login.authorizePass(username, password);

            // Get the window.
            BankWindow window = WindowHandler.getInstance().getWindow(0);

            // Get the user handler.
            UserHandler userHandler = UserHandler.getInstance();

            if(success){
                // As well, set the current user in the UserHandler.
                userHandler.setCurrentUser(login.getUser(username));

                // Set the segment to the KnownUserSegment.
                window.setSegment(new KnownUserSegment());
                // If we failed logging in.
            } else {
                // Set the current segment to the popup segment, tell it to play the sound.
                new PopupSegment(
                        "Login Error",
                        "The username or password is incorrect.",
                        true
                );
            }
        });
    }
}
