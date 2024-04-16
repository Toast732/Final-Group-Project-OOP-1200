package javaProject.methods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaProject.methods.Login;




public class bankingGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel loginStatusLabel;

    public bankingGUI() {
        createUI();
    }

    private void createUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Username"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        loginButton = new JButton("javaProject.methods.Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
        add(loginButton);

        loginStatusLabel = new JLabel();
        add(loginStatusLabel);

        setVisible(true);
    }

    private void performLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        Login login = new Login();
        if (login.authorizePass(username, password)) {
            loginStatusLabel.setText("javaProject.methods.Login Successful!");

        } else {
            loginStatusLabel.setText("javaProject.methods.Login Failed!");
        }
    }

    public static  void main(String[] args) {
        new bankingGUI();
    }
}