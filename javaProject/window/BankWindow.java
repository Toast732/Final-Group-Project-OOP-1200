package javaProject.window;

import javaProject.debug.DebugPrint;
import javaProject.pageSegments.PageSegment;

import javax.swing.*;
import java.awt.*;


public class BankWindow {

    public final String title;

    protected JFrame jFrame;

    protected PageSegment currentSegment;

    public BankWindow(String title) {

        // Set the title.
        this.title = title;

        // Create the JFrame
        this.jFrame = new JFrame(this.title);

        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.jFrame.setPreferredSize(new java.awt.Dimension(500, 500));
        //this.jFrame.setSize(500, 500);
        //this.display();

    }

    public void setSegment(PageSegment segment) {
        // Check if there was a previous segment.
        if(this.currentSegment != null){
            // Then remove the segment.
            this.jFrame.remove(this.currentSegment.getPane());
        }

        // Set the current segment to this one we just got.
        this.currentSegment = segment;

        // Add this to the frame.
        this.jFrame.add(segment.getPane());

        // Update the window.
        this.update();
    }

    // Updates the window.
    public void update(){

        DebugPrint.info("Updating window: " + this.title);

        // Invalidate the old window data.
        jFrame.invalidate();

        // Validate it with the new data.
        jFrame.validate();

        // Repaint the window.
        jFrame.repaint();
    }

    public void display() {
        this.jFrame.pack();
        this.jFrame.setVisible(true);
        this.jFrame.setExtendedState(this.jFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    // Function to play an error sound, uses the system's error sound (Windows specific).
    // Adapted from https://stackoverflow.com/a/18103204
    public void soundError() {
        // Get the default toolkit. (Specific OS Properties)
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // Get the error sound, cast to a Runnable.
        Runnable errorSound = (Runnable) toolkit.getDesktopProperty("win.sound.exclamation");

        // Play the sound (if it's not null).
        if (errorSound != null) {
            errorSound.run();
        }
    }
}