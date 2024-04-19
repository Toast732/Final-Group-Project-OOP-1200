package javaProject.pages;

import javaProject.transactions.OneTimeTransaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTransactionPage extends NormalPage {

    public AddTransactionPage() {
        super("Add Transaction Page", new FlowLayout());

        JPanel inputGridPanel = new JPanel(new GridLayout(8, 2));

        JTextField AmountField = new JTextField(32);

        // Create the Amount label.
        JLabel AmountLabel = new JLabel("Amount:");

        JTextField TransactionNameField = new JTextField(32);

        JLabel ConfirmLabel = new JLabel("Generate new transaction");

        JButton ConfirmButton = new JButton("Add transaction");

        ConfirmButton.setSize(new Dimension(50, 30));

        JLabel ConfirmButtonClicked = new JLabel("");

        // Create the Amount label.
        JLabel TransactionNameLabel = new JLabel("Transaction Title:");

        JButton ResetButton = new JButton("Clear boxes");

        inputGridPanel.add(TransactionNameLabel);
        inputGridPanel.add(TransactionNameField);
        inputGridPanel.add(AmountLabel);
        inputGridPanel.add(AmountField);
        inputGridPanel.add(ConfirmLabel);
        inputGridPanel.add(ConfirmButton);
        inputGridPanel.add(ConfirmButtonClicked);
        inputGridPanel.add(ResetButton);
        this.jPanel.add(inputGridPanel);

        ConfirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer amount = Integer.parseInt(AmountField.getText());
                String transactionName = TransactionNameField.getText();
                ConfirmButtonClicked.setText("Generated transaction");
            }
        });
        ResetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AmountField.setText("");
                TransactionNameField.setText("");
                ConfirmButtonClicked.setText("");
            }
        });
    }
}
