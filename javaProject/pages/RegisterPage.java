package javaProject.pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javaProject.methods.Login;

public class RegisterPage extends NormalPage {

    private JTextField usernameField, nameField, familyField, emailField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JLabel registrationStatusLabel;
    private Login login;

    public RegisterPage() {
        // Create the page for this, and call it "Register"
        super("Register", new GridLayout(3, 1)); // Set the layout of the RegisterPage to GridLayout with 3 rows and 1 column

        JPanel inputPanel = new JPanel(new GridLayout(5, 2)); // Create a panel for input fields with GridLayout 5 rows and 2 columns

        inputPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        inputPanel.add(usernameField);

        inputPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        inputPanel.add(passwordField);

        inputPanel.add(new JLabel("First Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Last Name:"));
        familyField = new JTextField();
        inputPanel.add(familyField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        JPanel buttonPanel = new JPanel(); // Create a panel for the register button
        registerButton = new JButton("Register");
        registerButton.addActionListener(this::performRegistration);
        buttonPanel.add(registerButton);

        JPanel statusPanel = new JPanel(); // Create a panel for the registration status label
        registrationStatusLabel = new JLabel();
        statusPanel.add(registrationStatusLabel);

        // Add the panels to the RegisterPage
        this.jPanel.add(inputPanel);
        this.jPanel.add(buttonPanel);
        this.jPanel.add(statusPanel);
    }

    private void performRegistration(ActionEvent event) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String name = nameField.getText();
        String lastName = familyField.getText();
        String email = emailField.getText();

        boolean success = login.register(username, password, name, lastName, email);
        if (success) {
            registrationStatusLabel.setText("Registration Successful! Please log in.");
        } else {
            registrationStatusLabel.setText("Registration Failed! Username already exists.");
        }
    }
}
