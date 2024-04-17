package javaProject.pageSegments;


import javaProject.pages.LoginPage;
import javaProject.pages.RegisterPage;
import javaProject.window.Window;

public class GuestUserSegment extends PageSegment {
    public GuestUserSegment(Window window){
        // Call the super class's constructor.
        super();

        // Add the login page to the segment.
        super.addPage(new LoginPage(window));

        // Add the register page to the segment.
        super.addPage(new RegisterPage());
    }
}
