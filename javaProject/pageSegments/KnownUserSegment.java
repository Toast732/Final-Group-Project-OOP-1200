package javaProject.pageSegments;


import javaProject.accounts.users.UserHandler;
import javaProject.methods.User;
import javaProject.pages.AddRegularTransactionPage;
import javaProject.pages.buttons.LogoutButton;

import javax.swing.*;

public class KnownUserSegment extends PageSegment {
    public KnownUserSegment(){
        // Call the super class's constructor.
        super();

        // Add the login page button to the segment.
        super.addToTopRight(new LogoutButton().button);

        // Get the current user.
        User user = UserHandler.getInstance().getUser();

        // Add a welcome message to the top left.
        super.addToTopLeft(new JLabel("Welcome, " + user.getUsername() + "!"));

        /*
            Add the pages.
        */

        // Add the regularTransactionPage.
        super.addPage(new AddRegularTransactionPage());
    }
}
