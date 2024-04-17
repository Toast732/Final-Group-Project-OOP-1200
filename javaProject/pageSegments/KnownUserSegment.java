package javaProject.pageSegments;


import javaProject.pages.LoginPage;

public class KnownUserSegment extends PageSegment {
    public KnownUserSegment(){
        // Call the super class's constructor.
        super();

        // Add the login page to the segment.
        super.addPage(new LoginPage());
    }
}
