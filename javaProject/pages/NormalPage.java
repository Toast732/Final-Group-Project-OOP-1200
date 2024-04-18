package javaProject.pages;

import javaProject.pageSegments.PageSegment;

import javax.swing.*;
import java.awt.*;

public abstract class NormalPage implements Page {

    protected final JPanel jPanel;
    private final String name;
    private PageSegment segment;

    public NormalPage(String name, LayoutManager layoutManager){
        // Set the name of the page.
        this.name = name;

        // Create the JPanel.
        this.jPanel = new JPanel(layoutManager);
    }

    // Overloaded constructor for when theres no LayoutManager given, defaults to GridBagLayout.
    public NormalPage(String name){
        // Call this constructor with the name and with the GridBagLayout.
        this(name, new GridBagLayout());
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
