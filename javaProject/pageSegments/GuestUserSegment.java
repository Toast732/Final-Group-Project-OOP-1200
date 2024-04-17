package javaProject.pageSegments;


import javaProject.pages.LoginPage;
import javaProject.pages.RegisterPage;

public class GuestUserSegment extends PageSegment {
    public GuestUserSegment(){
        // Call the super class's constructor.
        super();

        // Add the login page to the segment.
        super.addPage(new LoginPage());

        // Add the register page to the segment.
        super.addPage(new RegisterPage());
    }
}
