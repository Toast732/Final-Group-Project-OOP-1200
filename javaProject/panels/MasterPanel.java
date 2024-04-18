package javaProject.panels;

import javax.swing.*;
import java.awt.*;

// The Master Panel, the one that's for the entire page.
public class MasterPanel extends JPanel {
    public JPanel topPanelGroup;
    public JPanel topPanelLeft;
    public JPanel topPanelRight;
    public JPanel bottomPanel;

    public MasterPanel() {
        // Set the layout as BorderLayout.
        this.setLayout(new BorderLayout());

        // Create the top panel.
        this.topPanelGroup = new JPanel(new BorderLayout());
        // Set it so it should only take up 50px of the height.
        this.topPanelGroup.setPreferredSize(new Dimension(0, 50));

        // Create the left part of the top panel.
        this.topPanelLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //this.topPanelLeft.setBackground(Color.BLUE);

        // Create the right part of the top panel.
        this.topPanelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        //this.topPanelRight.setBackground(Color.RED);

        // Add the left panel to the top panel, on the left.
        this.topPanelGroup.add(this.topPanelLeft, BorderLayout.LINE_START);

        // Add the right panel to the top panel, on the right.
        this.topPanelGroup.add(this.topPanelRight, BorderLayout.LINE_END);

        // Create the bottom panel
        this.bottomPanel = new JPanel();
        //this.bottomPanel.setBackground(Color.GREEN);

        // Add the panels to the master panel.
        this.add(this.topPanelGroup, BorderLayout.NORTH);
        this.add(this.bottomPanel, BorderLayout.CENTER);
    }
}
