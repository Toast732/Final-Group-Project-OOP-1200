package javaProject.panels;

import javaProject.lambda.PanelOutFunction;
import javaProject.window.WindowHandler;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

// A dropdown panel that you can add different elements to based upon the selection.
public class DropdownPanel extends JPanel {

    private final JComboBox<String> dropdownComponent;
    private final Map<String, PanelOutFunction> dropdownItemMap = new HashMap<>();
    private JPanel variablePanel;
    private boolean enableActionListener = true;

    private JPanel grid;

    public DropdownPanel(String label) {

        // Set the layout
        this.setLayout(new GridBagLayout());

        JPanel interiorGrid = new JPanel(new GridLayout(1, 2));

        // Create the label panel, have it aligned to the right via FlowLayout.
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // Create the label.
        JLabel labelComponent = new JLabel(label);

        // Create the dropdown panel, have it aligned to the left via FlowLayout.
        JPanel dropdownPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Create the dropdown.
        this.dropdownComponent = new JComboBox<>();

        // Assign the ActionListener
        this.dropdownComponent.addActionListener(e -> {
            if (enableActionListener) {
                // Get the selected item.
                JComboBox<String> source = (JComboBox<String>) e.getSource();
                String selected = (String) source.getSelectedItem();

                // Call the function.
                dropdownChanged(selected);
            }
        });

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0; // Set weightx to 0
        constraints.weighty = 0; // Set weighty to 0
        constraints.gridx = 0;

        // Add the label to the first row
        constraints.gridy = 0;
        labelPanel.add(labelComponent);
        interiorGrid.add(labelPanel, constraints);

        // Add the dropdown to the second row
        constraints.gridy = 1;
        dropdownPanel.add(this.dropdownComponent);
        interiorGrid.add(dropdownPanel, constraints);

        // Add the interior grid to the main grid
        constraints.gridy = 0;
        this.add(interiorGrid, constraints);
    }

    // Method for adding an item to the dropdown.
    public void addDropdownItem(String itemName, PanelOutFunction lambda) {

        // If this is the first element, have it default selected.
        if (!this.dropdownItemMap.isEmpty()) {
            this.enableActionListener = false;
        }

        // Add the lambda to the map.
        this.dropdownItemMap.put(itemName, lambda);

        // Add the item to the dropdown.
        this.dropdownComponent.addItem(itemName);

        this.enableActionListener = true;
    }

    // Method called when the selected item in the dropdown is changed.
    private void dropdownChanged(String selectedItem) {

        // Get the lambda from the map.
        PanelOutFunction lambda = this.dropdownItemMap.get(selectedItem);

        // Call the lambda.
        JPanel newPanel = lambda.run();

        // If there is a variable panel, remove it.
        if (this.variablePanel != null) {
            this.remove(this.variablePanel);
        }

        // Set the variable panel to the new panel.
        this.variablePanel = newPanel;

        //this.variablePanel.setPreferredSize(new Dimension(1920, 1080));

        // Add the new panel to the main panel.
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 1;
        this.add(this.variablePanel, constraints);

        //this.grid.set(new LineBorder(Color.CYAN));

        //this.grid.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
        //this.grid.add(new JLabel("SEND HELP"));

        // Update the window
        WindowHandler.getInstance().getWindow(0).update();
    }
}
