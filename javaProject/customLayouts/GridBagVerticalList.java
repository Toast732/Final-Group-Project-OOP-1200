package javaProject.customLayouts;

import javax.swing.*;
import java.awt.*;

public class GridBagVerticalList extends Container {
    private int previous_y = 0;

    private JPanel jPanel;

    private Component capComponent;

    private GridBagConstraints constraints;

    private Component leftBuilder;

    private Component rightBuilder;

    public GridBagVerticalList(JPanel jPanel){
        this.jPanel = jPanel;

        this.capComponent = new JLabel(" ".repeat(1));

        // Add the cap component to the panel.
        this.jPanel.add(this.capComponent);

        this.constraints = new GridBagConstraints();

        // Add the top builder elements
        //this.jPanel.add(new JLabel("1", constraints));
    }

    public Component add(Component component, int row){
        this.constraints.insets = new Insets(10,0,0,0); // Set the padding.
        this.constraints.gridy = row; // Set it's position in the grid.

        this.constraints.ipadx = 10;
        this.constraints.ipady = 10;

        // Custom Styling for different types of components.
        switch(component.getClass().getName()){
            case "javax.swing.JButton":
                this.constraints.ipadx = 0;
                this.constraints.gridwidth = 2;
                this.constraints.fill = GridBagConstraints.HORIZONTAL;
                break;
            case "javax.swing.JTextField":
                this.constraints.anchor = GridBagConstraints.FIRST_LINE_START;
                this.constraints.weightx = 0;
                break;
            case "javax.swing.JLabel":
                this.constraints.anchor = GridBagConstraints.FIRST_LINE_END;
                this.constraints.weightx = 1;
                break;
            default:
                break;
        }

        // Add the component to the panel.
        this.jPanel.add(component, this.constraints);

        /*
            Push the cap component down below this element
        */

        // Remove the current cap component.
        this.jPanel.remove(this.capComponent);

        GridBagConstraints capConstraints = new GridBagConstraints();

        // Give it a y-axis weight of 1 - the only one with a weight.
        capConstraints.weighty = 1;

        // Put its grid y below this element.
        capConstraints.gridy = previous_y;

        // Add the component to the panel.
        this.jPanel.add(capComponent, capConstraints);

        // Return the created component.
        return component;
    }

    // Overloaded method for when theres no y_spacing given.
    public Component add(Component component){
        return this.add(component, this.previous_y++);
    }
}