package javaProject.pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;
import javaProject.methods.Login;
import javaProject.pageSegments.PopupSegment;

public class RegisterPage extends NormalPage {

    //entry fields
    private JTextField
            usernameField,
            nameField,
            familyField,
            emailField,
            confirmEmailField;

    //Password entry and confirmation
    private JPasswordField passwordField;
    private JPasswordField checkPasswordField;

    //Error labels
    private JLabel
            usernameErrorLabel,
            passwordErrorLabel,
            confirmPasswordErrorLabel,
            nameErrorLabel, lastNameErrorLabel,
            emailErrorLabel,
            emailConfirmErrorLabel;

    //Register button and label
    private JButton registerButton;
    private JLabel registrationStatusLabel;

    //private instance of Login
    private Login login;

    //Variable to hold the RegEx for email found at https://stackoverflow.com/questions/201323/how-can-i-validate-an-email-address-using-a-regular-expression
    private String PROPER_EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])";

    public RegisterPage() {
        // Create the page for this, and call it "Register"
        super("Register", new GridLayout(3, 1)); // Set the layout of the RegisterPage
        this.login = new Login();

        JPanel inputPanel = new JPanel(new GridLayout(7, 3)); // Create a panel for input fields with GridLayout

        inputPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        inputPanel.add(usernameField);
        usernameErrorLabel = new JLabel();
        inputPanel.add(usernameErrorLabel);

        inputPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        inputPanel.add(passwordField);
        passwordErrorLabel = new JLabel();
        inputPanel.add(passwordErrorLabel);

        inputPanel.add(new JLabel("Confirm Password:"));
        checkPasswordField = new JPasswordField();
        inputPanel.add(checkPasswordField);
        confirmPasswordErrorLabel = new JLabel();
        inputPanel.add(confirmPasswordErrorLabel);

        inputPanel.add(new JLabel("First Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        nameErrorLabel = new JLabel();
        inputPanel.add(nameErrorLabel);

        inputPanel.add(new JLabel("Last Name:"));
        familyField = new JTextField();
        inputPanel.add(familyField);
        lastNameErrorLabel = new JLabel();
        inputPanel.add(lastNameErrorLabel);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);
        emailErrorLabel = new JLabel();
        inputPanel.add(emailErrorLabel);

        inputPanel.add(new JLabel("Confirm Email:"));
        confirmEmailField = new JTextField();
        inputPanel.add(confirmEmailField);
        emailConfirmErrorLabel = new JLabel();
        inputPanel.add(emailConfirmErrorLabel);

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
        String username = usernameField.getText().toLowerCase();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(checkPasswordField.getPassword());
        String name = nameField.getText();
        String lastName = familyField.getText();
        String email = emailField.getText();
        String confrimEmail = confirmEmailField.getText();

        //Clear previous errors
        clearErrorLabels();
        // Initialize a flag to indicate if any validation failed
        boolean validationFailed = false;

        // Check for invalid characters
        if (containsInvalidCharacter(
                username,
                password,
                name,
                lastName,
                email)) {
            registrationStatusLabel.setText("Invalid character '|' detected.");
            validationFailed = true;
        }

        // Check for blank fields
        if (username.trim().isEmpty()) {
            usernameErrorLabel.setText("Username cannot be blank.");
            validationFailed = true;
        }

        if (password.trim().isEmpty()) {
            passwordErrorLabel.setText("Password cannot be blank.");
            validationFailed = true;
        }

        if (confirmPassword.trim().isEmpty()) {
            checkPasswordField.setText("Password cannot be blank.");
            validationFailed = true;
        }

        if (name.trim().isEmpty()) {
            nameErrorLabel.setText("First Name cannot be blank.");
            validationFailed = true;
        }

        if (name.trim().isEmpty()) {
            nameErrorLabel.setText("First Name cannot be blank.");
            validationFailed = true;
        }

        if (lastName.trim().isEmpty()) {
            lastNameErrorLabel.setText("Last Name cannot be blank.");
            validationFailed = true;
        }

        if (email.trim().isEmpty()) {
            emailErrorLabel.setText("Email cannot be blank.");
            validationFailed = true;
        }

        if (confrimEmail.trim().isEmpty()) {
            emailConfirmErrorLabel.setText("Email cannot be blank.");
            validationFailed = true;
        }

        // Check if username is valid
        if (!isValidUsername(username)) {
            usernameErrorLabel.setText("Invalid username. Only allowed letters, digits, periods, underscores, and hyphens");
            validationFailed = true;
        }

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            passwordErrorLabel.setText("Passwords do not match.");
            confirmPasswordErrorLabel.setText("Passwords do not match.");
            validationFailed = true;
        }

        // Check if Emails match
        if (!email.equals(confrimEmail)) {
            passwordErrorLabel.setText("Email and confirmation email does not match.");
            confirmPasswordErrorLabel.setText("Email and confirmation email does not match.");
            validationFailed = true;
        }

        //Check for valid email
        if (!isValidEmail(email.trim())) {
            emailErrorLabel.setText("Invalid email format.");
            validationFailed = true;
        }


        // Check for spaces in the email
        if (email.contains(" ")) {
            emailErrorLabel.setText("Email should not contain spaces.");
            validationFailed = true;
        }

        if (!isValidEmail(email.trim())) {
            emailErrorLabel.setText("Invalid email format.");
            validationFailed = true;
        }

        // If any validation failed, don't proceed with registration
        if (validationFailed) {
            return; // Early return if validation fails
        }
        boolean success = login.register(
                username,
                password,
                name,
                lastName,
                email);
        if (success) {
            new PopupSegment("Registration Successful!", "Go back to login and use your Username:" + username + " and Password.", false);
            clearErrorLabels();
            clearFields();

            registrationStatusLabel.setText("Registration Successful! Please log in.");
        } else {
            registrationStatusLabel.setText("Registration Failed! Username already exists.");
        }


    }
    // Clear errors
    private void clearErrorLabels() {
        usernameErrorLabel.setText("");
        passwordErrorLabel.setText("");
        confirmPasswordErrorLabel.setText("");
        nameErrorLabel.setText("");
        lastNameErrorLabel.setText("");
        emailErrorLabel.setText("");
        emailConfirmErrorLabel.setText("");
    }
    // Clear entry fields
    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
        checkPasswordField.setText("");
        nameField.setText("");
        familyField.setText("");
        emailField.setText("");
        confirmEmailField.setText("");
    }

    //As I will need to check multiple arguments potentially due to my use of | as a delimiter
    //and if for some reason one makes it through, I need a way to check more than my limit of
    //arguments since I have already established the number of fields at the start.
    //I checked online for a way to have a flexible number to work with and found '...'
    //https://www.programiz.com/java-programming/varargs Java Varargs or variable arguments!
    //This way my method can accept an arbitrary number of values.
    private boolean containsInvalidCharacter(String... fields) {
        for (String field : fields) {
            if (field.contains("|")) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidUsername(String username) {
        return username.matches("[a-zA-Z0-9._-]+"); // Only allow letters, digits, periods, underscores, and hyphens
    }
    private boolean isValidEmail(String email) {
        String emailRegex = PROPER_EMAIL;
        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pattern.matcher(email).matches();
    }

}
