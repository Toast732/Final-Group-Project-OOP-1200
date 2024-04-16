package javaProject.methods.guiElements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaProject.methods.Login;
import javaProject.methods.guiElements.*;

public class bankingGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel loginStatusLabel;
    private JButton showRegistrationButton;

    public bankingGUI() {
        createUI();
    }

    private void createUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Username"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(e -> performLogin());
        add(loginButton);

        loginStatusLabel = new JLabel();
        add(loginStatusLabel);

        showRegistrationButton = new JButton("Register New User");
        showRegistrationButton.addActionListener(e -> {
            Login login = new Login();
            new registerGUI(login);
        });
        add(showRegistrationButton);

        setVisible(true);
    }

    private void performLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        Login login = new Login();
        if (login.authorizePass(username, password)) {
            loginStatusLabel.setText("Login Successful!");
            dispose(); // Close the login window
            new UserProfileGUI(login.getUser(username)); // Pass the User object to the profile GUI
        } else {
            loginStatusLabel.setText("Login Failed!");
        }
    }
   /* comment line -  remove slash and asterix to test
    public static void main(String[] args) {
        new bankingGUI(); // Main method to launch GUI if needed in this class
 */
}
