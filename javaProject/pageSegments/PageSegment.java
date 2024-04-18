package javaProject.pageSegments;

import javaProject.debug.DebugPrint;
import javaProject.pages.Page;

import javax.swing.*;

public abstract class PageSegment {

    private final JTabbedPane jTabbedPane;

    public PageSegment(){

        // Print an info message.
        DebugPrint.info("Building a new PageSegment");

        // Create a tabbed pane.
        this.jTabbedPane = new JTabbedPane();
    }

    public void addPage(Page page){
        // Get the page's name.
        String pageName = page.getName();

        // Print an info message.
        DebugPrint.info("Adding page: " + pageName);

        // Add the page to the tabbed pane.
        this.jTabbedPane.addTab(pageName, page.getJPanel());
    }

    public JTabbedPane getPane(){
        return this.jTabbedPane;
    }
}
