package javaProject.pageSegments;

import javaProject.pages.Page;

import javax.swing.*;

public abstract class PageSegment {

    private final JTabbedPane jTabbedPane;

    public PageSegment(){
        // Create a tabbed pane.
        this.jTabbedPane = new JTabbedPane();
    }

    public void addPage(Page page){
        this.jTabbedPane.addTab(page.getName(), page.getJPanel());
    }

    public JTabbedPane getPane(){
        return this.jTabbedPane;
    }
}
