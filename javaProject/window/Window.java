package javaProject.window;

import javaProject.pageSegments.PageSegment;

import javax.swing.*;
import java.awt.*;


public class Window extends JFrame {

    public final String title;

    protected JFrame jFrame;

    protected PageSegment currentSegment;

    public Window(String title){

        // Set the title.
        this.title = title;

        // Create the JFrame
        this.jFrame = new JFrame(this.title);

        this.jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        this.jFrame.setExtendedState(this.getExtendedState() | MAXIMIZED_BOTH);
    }
}