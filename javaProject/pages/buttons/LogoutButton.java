package javaProject.pages.buttons;

import javaProject.accounts.users.UserHandler;
import javaProject.pageSegments.GuestUserSegment;
import javaProject.window.BankWindow;
import javaProject.window.WindowHandler;

public class LogoutButton extends PageButton {
    public LogoutButton() {
        super("Logout");
    }

    public void onClick() {
        // Get the User Handler Instance.
        UserHandler userHandler = UserHandler.getInstance();

        // Get the window.
        BankWindow window = WindowHandler.getInstance().getWindow(0);

        // Set the current user to null.
        userHandler.setCurrentUser(null);

        // Set the segment to the GuestUserSegment.
        window.setSegment(new GuestUserSegment());
    }
}
