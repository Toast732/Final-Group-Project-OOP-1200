package javaProject.window;

import javaProject.pageSegments.PageSegment;

import javax.swing.*;


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
        this.jFrame.setSize(500, 500);

        //JFrame frame = new JPanel(new GridBagLayout());
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(200, 200);
        //setLocationRelativeTo(null);
        //setLayout(new GridBagLayout());

    }

    public void setSegment(PageSegment segment) {
        this.currentSegment = segment;
        this.jFrame.add(segment.getPane());
    }

    public void display() {
        this.jFrame.pack();
        this.jFrame.setVisible(true);
    }
}