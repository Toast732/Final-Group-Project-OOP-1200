package javaProject.pages;

import javax.swing.*;
import java.awt.*;

public class AddRegularTransactionPage extends NormalPage {

    public AddRegularTransactionPage() {
        super("Add Regular Transaction", new FlowLayout());

        // Create a dropdown selection for the transaction type (yearly or hourly)
        String[] transactionTypes = {"Yearly", "Hourly"};

        // Create the dropdown
        JComboBox<String> transactionTypeDropdown = new JComboBox<>(transactionTypes);

        // Create the label for the dropdown
        JLabel transactionTypeLabel = new JLabel("Transaction Type:");

        // Create the panel for the dropdown
        JPanel transactionTypePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // Add the label to the panel
        transactionTypePanel.add(transactionTypeLabel);

        // Create the panel for the dropdown
        JPanel transactionTypeDropdownPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Add the dropdown to the panel
        transactionTypeDropdownPanel.add(transactionTypeDropdown);

        // Add the panels to the page
        this.jPanel.add(transactionTypePanel);

        this.jPanel.add(transactionTypeDropdownPanel);
    }

}
