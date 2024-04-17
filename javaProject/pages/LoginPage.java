package javaProject.pages;

import javax.swing.*;

import javaProject.methods.Login;

import javaProject.customLayouts.GridBagVerticalList;

import java.awt.*;

public class LoginPage extends NormalPage {

    public LoginPage() {
        // Create the page for this, and call it "Login"
        super("Login");

        // Create a 2x2 grid panel for the username and password.

        // Create a new panel with the grid layout.
        JPanel inputGridPanel = new JPanel(new GridLayout(2, 2));

        this.jPanel.add(inputGridPanel);

        // Create the vertical list.
        GridBagVerticalList verticalList = new GridBagVerticalList(this.jPanel);

        // Create the Username field.
        JTextField userNameField = new JTextField(32);



        // Create the username JPanel.
        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        // Add the label to the layout.
        usernamePanel.add(new JLabel("Username:"));

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
        //verticalList.add(usernameLabel, 0);
        //verticalList.add(userNameField);
        //verticalList.add(passwordLabel, 1);
        //verticalList.add(passwordField);
        verticalList.add(inputGridPanel);
        verticalList.add(loginButton);
    }
}
