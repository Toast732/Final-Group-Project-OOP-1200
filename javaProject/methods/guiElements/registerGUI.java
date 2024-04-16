package javaProject.methods.guiElements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaProject.methods.Login;

public class registerGUI extends JFrame {
    private JTextField usernameField, nameField, addressField, phoneNumberField, emailField, favoriteAnimalField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JLabel registrationStatusLabel;

    private Login login;  // Reference to the Login object

    public registerGUI(Login login) {
        this.login = login; // Store the login reference for registration checks
        createUI();
    }

    private void createUI() {
        setTitle("User Registration");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setLayout(new GridLayout(0, 2));

        // Adding fields for user input
        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Address:"));
        addressField = new JTextField();
        add(addressField);

        add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        add(phoneNumberField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Favorite Animal:"));
        favoriteAnimalField = new JTextField();
        add(favoriteAnimalField);

        registerButton = new JButton("Register");
        registerButton.addActionListener(this::performRegistration);
        add(registerButton);

        registrationStatusLabel = new JLabel();
        add(registrationStatusLabel);

        setVisible(true);
    }

    private void performRegistration(ActionEvent event) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String name = nameField.getText();
        String address = addressField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();
        String favoriteAnimal = favoriteAnimalField.getText();

        boolean success = login.register(username, password, name, address, phoneNumber, email, favoriteAnimal);
        if (success) {
            registrationStatusLabel.setText("Registration Successful! Please log in.");
            dispose(); // Optionally close the registration window after successful registration
        } else {
            registrationStatusLabel.setText("Registration Failed! Username already exists.");
        }
    }
}
