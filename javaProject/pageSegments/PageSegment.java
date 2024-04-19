package javaProject.pageSegments;

import javaProject.debug.DebugPrint;
import javaProject.pages.Page;

import javax.swing.*;
import java.awt.*;

public abstract class PageSegment {

    private final JTabbedPane jTabbedPane;

    public final JPanel NWPane;
    private final JPanel NEPane;

    public PageSegment(){

        // Print an info message.
        DebugPrint.info("Building a new PageSegment");

        // Create a new JPanel for the buttons.
        this.NEPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // Create a new JPanel for the West pane.
        this.NWPane = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Get the screen Size.
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Create a tabbed pane.
        this.jTabbedPane = new JTabbedPane();

        // Set the preferred size to the screen size, that way, it makes it as big as possible.
        this.jTabbedPane.setPreferredSize(
                new java.awt.Dimension(
                        (int) screenSize.getWidth(),
                        (int) screenSize.getHeight()
                )
        );
    }

    public void addPage(Page page){
        // Get the page's name.
        String pageName = page.getName();

        // Print an info message.
        DebugPrint.info("Adding page: " + pageName);

        // Add the page to the tabbed pane.
        this.jTabbedPane.addTab(pageName, page.getJPanel());
    }

    public void addToTopRight(Component component) {
        this.NEPane.add(component);
    }

    public void addToTopLeft(Component component) {
        this.NWPane.add(component);
    }

    public JTabbedPane getTabbedPane() {
        return this.jTabbedPane;
    }

    public JPanel getNWPane() {
        return this.NWPane;
    }

    public JPanel getNEPane() {
        return this.NEPane;
    }
}
