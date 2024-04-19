package javaProject.pages;

import javaProject.accounts.users.UserHandler;
import javaProject.pageSegments.GuestUserSegment;
import javaProject.pageSegments.PageSegment;
import javaProject.pageSegments.PopupSegment;
import javaProject.window.WindowHandler;

import javax.swing.*;
import java.awt.*;

public class PopupPage extends NormalPage {
    public PopupPage(String popupName, String popupText) {
        super(popupName, new FlowLayout());

        JPanel gridPanel = new JPanel(new GridLayout(2, 1));

        this.jPanel.add(gridPanel);

        // Create a label with the popup text.
        JLabel popupTextLabel = new JLabel(popupText);

        // Add the label to the panel.
        gridPanel.add(popupTextLabel);

        // Create a button to close the popup.
        JButton closeButton = new JButton("Dismiss");

        closeButton.setSize(new Dimension(100, 50));

        // Add an action listener to the button.
        closeButton.addActionListener(e -> {
            // Close the popup.
            closePopup();
        });

        // Add the button to the panel.
        gridPanel.add(closeButton);
    }

    private void closePopup() {

        // Close the popup.
        PageSegment currentSegment = WindowHandler.getInstance().getWindow(0).getSegment();

        // Don't go further if the current segment is not a popup segment, instead, return to guest user segment.
        if (currentSegment.getClass() != PopupSegment.class) {

            // Set the segment to the guest user segment.
            WindowHandler.getInstance().getWindow(0).setSegment(new GuestUserSegment());

            // Logout the user.
            UserHandler.getInstance().setCurrentUser(null);

            // Return.
            return;
        }

        // Close the popup.
        ((PopupSegment) currentSegment).closePopup();
    }
}
