package javaProject.pages;

import javax.swing.*;
import java.awt.*;

public class AddTransactionPage extends NormalPage {

    public AddTransactionPage() {
        super("Add Transaction Page", new FlowLayout());

        JPanel inputGridPanel = new JPanel(new GridLayout(6, 2));

        JTextField AmountField = new JTextField(32);

        // Create the Amount label.
        JLabel AmountLabel = new JLabel("Amount:");

        JTextField TransactionNameField = new JTextField(32);

        JLabel ConfirmLabel = new JLabel("Generate new transaction");

        JButton ConfirmButton = new JButton("Add transaction");

        ConfirmButton.setSize(new Dimension(50, 30));

        // Create the Amount label.
        JLabel TransactionNameLabel = new JLabel("Transaction Title:");

        inputGridPanel.add(TransactionNameLabel);
        inputGridPanel.add(TransactionNameField);
        inputGridPanel.add(AmountLabel);
        inputGridPanel.add(AmountField);
        inputGridPanel.add(ConfirmLabel);
        inputGridPanel.add(ConfirmButton);
        this.jPanel.add(inputGridPanel);
    }
}
