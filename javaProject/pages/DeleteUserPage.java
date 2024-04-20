package javaProject.pages;

import javaProject.accounts.users.UserHandler;
import javaProject.methods.Login;
import javaProject.methods.User;
import javaProject.pageSegments.GuestUserSegment;
import javaProject.window.WindowHandler;

import javax.swing.*;
import java.awt.*;

public class DeleteUserPage extends NormalPage {
    public DeleteUserPage() {
        super("Delete User", new FlowLayout());

        // Create the panel for the page.
        JPanel deletePanel = new JPanel();

        JPanel passwordGridPanel = new JPanel(new GridLayout(0, 2));

        JPanel passwordFieldPanel = new JPanel();

        JPanel passwordLabelPanel = new JPanel();

        // Add the label panel to the grid panel.
        passwordGridPanel.add(passwordLabelPanel);

        // Add the field panel to the grid panel.
        passwordGridPanel.add(passwordFieldPanel);

        // Add a field to input the user's password.
        JLabel passwordLabel = new JLabel("Password");

        // Add the label to the label panel.
        passwordLabelPanel.add(passwordLabel);

        // Add a field to input the user's password.
        JPasswordField passwordField = new JPasswordField(32);

        // Add the field to the panel.
        passwordFieldPanel.add(passwordField);

        // Create a button asking if the user want's to delete their account
        JButton deleteButton = new JButton("Delete Account");

        // Add an action listener to the button.
        deleteButton.addActionListener(e -> {

            // Get the current user.
            User user = UserHandler.getInstance().getUser();

            // If the password is incorrect, show an error message.
            if (!user.getPassword().equals(passwordField.getText())) {
                JOptionPane.showMessageDialog(null, "Incorrect password.");
                return;
            }

            // Otherwise, delete the user.
            user.delete();

            new Login().deleteUser(user.getUsername());

            // Set the segment to the GuestUserSegment

            // Create the guest user segment.
            GuestUserSegment guestUserSegment = new GuestUserSegment();

            // Set the current user to null.
            UserHandler.getInstance().setCurrentUser(null);

            // Set the segment to the guest user segment.
            WindowHandler.getInstance().getWindow(0).setSegment(guestUserSegment);
        });

        // Add the grid panel to the panel.
        deletePanel.add(passwordGridPanel);

        // Add the button to the panel.
        deletePanel.add(deleteButton);

        // Add the panel to the page.
        this.jPanel.add(deletePanel);
    }

}
