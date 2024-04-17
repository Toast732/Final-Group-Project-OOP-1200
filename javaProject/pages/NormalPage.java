package javaProject.pages;

import javaProject.pageSegments.PageSegment;

import javax.swing.*;

public abstract class NormalPage implements Page {

    protected final JPanel jPanel;
    private final String name;
    private PageSegment segment;

    public NormalPage(String name){
        this.name = name;

        // Create the panel for this page.
        this.jPanel = new JPanel();

        // Create a text field for this page.
        //this.jPanel.add(new JTextField("TextField", 20));
    }

    public void assignSegment(PageSegment segment){
        this.segment = segment;

        //this.segment.
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setActive() {

    }

    @Override
    public JPanel getJPanel() {
        return this.jPanel;
    }
}
