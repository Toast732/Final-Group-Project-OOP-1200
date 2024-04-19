package javaProject.pages;


import javax.swing.*;
import java.awt.Window;
import java.awt.event.ActionEvent;
import javaProject.methods.Login;
import javaProject.accounts.users.UserHandler;

public class RegisterPage extends NormalPage {

    private JTextField usernameField, nameField, familyField, emailField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JLabel registrationStatusLabel;
    private Login login;
    
    public RegisterPage() {
        // Create the page for this, and call it "Register"
        super("Register");

        this.jPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        this.jPanel.add(usernameField);

        this.jPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        this.jPanel.add(passwordField);

        this.jPanel.add(new JLabel("First Name:"));
        nameField = new JTextField();
        this.jPanel.add(nameField);

        this.jPanel.add(new JLabel("Last Name:"));
        familyField = new JTextField();
        this.jPanel.add(familyField);

        this.jPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        this.jPanel.add(emailField);

        this.registerButton = new JButton("Register");
        registerButton.addActionListener(this::performRegistration);
        this.jPanel.add(registerButton);

        this.registrationStatusLabel = new JLabel();
        this.jPanel.add(registrationStatusLabel);
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
