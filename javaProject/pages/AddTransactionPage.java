package javaProject.pages;

import javax.swing.*;
import java.awt.*;

public class AddTransactionPage extends NormalPage {

    public AddTransactionPage() {
        super("Add Transaction Page", new FlowLayout());

        JPanel inputGridPanel = new JPanel(new GridLayout(1, 2));


        JTextField AmountField = new JTextField(32);

        // Create the Amount label.
        JLabel AmountLabel = new JLabel("Amount:");

        inputGridPanel.add(AmountLabel);
        inputGridPanel.add(AmountField);
        this.jPanel.add(inputGridPanel);
    }
}
