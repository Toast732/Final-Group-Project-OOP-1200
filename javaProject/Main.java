package javaProject;

import javaProject.pageSegments.GuestUserSegment;
import javaProject.pageSegments.PageSegment;
import javaProject.window.BankWindow;
import javaProject.window.WindowHandler;

public class Main {

    // Store the name of the bank.
    static final String bankName = "Delibe Financial Manager";

    static final WindowHandler windowHandler = WindowHandler.getInstance();

    public static void main(String[] args) {

        // Create a new window.
        BankWindow window = new BankWindow(bankName);

        // Add the window to the window handler.
        windowHandler.addWindow(window);

        //UserHandler.getInstance().setCurrentUser(new Login().getUser(""));

        // Create the GuestUserSegment.
        PageSegment guestUserSegment = new GuestUserSegment();

        // guestUserSegment = new KnownUserSegment();

        window.setSegment(guestUserSegment);

        window.display();
    }
}