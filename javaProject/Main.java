package javaProject;

import javaProject.pageSegments.GuestUserSegment;
import javaProject.pageSegments.PageSegment;
import javaProject.window.Window;

public class Main {

    // Store the name of the bank.
    static final String bankName = "Delibe Bank";

    public static void main(String[] args) {
        Window window = new Window(bankName);

        // Create the GuestUserSegment.
        PageSegment guestUserSegment = new GuestUserSegment();

        window.setSegment(guestUserSegment);

        window.display();
    }
}