package javaProject.pages;

import javax.swing.*;

public class LoginPage extends NormalPage {

    public LoginPage() {
        // Create the page for this, and call it "Login"
        super("Login");

        this.jPanel.add(new JLabel("Login Page"));
    }
}
