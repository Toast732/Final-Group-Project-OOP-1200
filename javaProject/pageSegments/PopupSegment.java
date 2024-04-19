package javaProject.pageSegments;

import javaProject.pages.PopupPage;
import javaProject.window.BankWindow;
import javaProject.window.WindowHandler;

public class PopupSegment extends PageSegment {

    private final PageSegment previousSegment;

    public PopupSegment(String popupName, String popupText, boolean playSound) {
        // Call the super class's constructor.
        super();

        // Get the current segment.
        this.previousSegment = WindowHandler.getInstance().getWindow(0).getSegment();

        /*
            Add the pages.
        */

        super.addPage(new PopupPage(popupName, popupText));


        // Get the window
        BankWindow window = WindowHandler.getInstance().getWindow(0);
        // Automatically make this the current segment.
        window.setSegment(this);

        // If we've been set to play the sound, play the sound.
        if (playSound) {
            // Play the error sound.
            window.soundError();
        }
    }

    public void closePopup() {
        // Set the current segment to the previous segment.
        WindowHandler.getInstance().getWindow(0).setSegment(this.previousSegment);
    }
}
