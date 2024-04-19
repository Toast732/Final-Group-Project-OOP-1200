package javaProject.pages;

import javaProject.accounts.users.UserHandler;
import javaProject.methods.User;
import javaProject.pageSegments.PopupSegment;
import javaProject.panels.DropdownPanel;
import javaProject.transactions.OneTimeTransaction;
import javaProject.transactions.RegularTransaction;

import javax.swing.*;
import java.awt.*;

public class AddExpensePage extends NormalPage {

    public AddExpensePage() {
        super("Add Expense", new FlowLayout());

        // Create the dropdown panel
        DropdownPanel transactionTypeDropdownPanel = new DropdownPanel("Expense Type:");

        // Add the items to the dropdown

        // Add Yearly
        transactionTypeDropdownPanel.addDropdownItem("Yearly", this::showYearlyMenu);

        // Add Monthly
        transactionTypeDropdownPanel.addDropdownItem("Monthly", this::showMonthlyMenu);

        // Add the one time
        transactionTypeDropdownPanel.addDropdownItem("One-time", this::showOneTimeMenu);

        // Add the dropdown panel to the page.
        this.jPanel.add(transactionTypeDropdownPanel);
    }

    private JPanel showYearlyMenu() {
        JPanel yearlyPanel = new JPanel(new GridLayout(2, 1));

        JPanel transactionGrid = new JPanel(new GridLayout(2, 2));

        // Add a label & field for the transaction name.
        JLabel transactionNameLabel = new JLabel("Expense Source Name:");

        JPanel transactionNamePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        transactionNamePanel.add(transactionNameLabel);

        JTextField transactionNameField = new JTextField(32);

        JPanel transactionNameFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        transactionNameFieldPanel.add(transactionNameField);

        transactionGrid.add(transactionNamePanel);

        transactionGrid.add(transactionNameFieldPanel);

        // Create the label for the yearly transaction amount
        JLabel yearlyTransactionAmountLabel = new JLabel("Yearly Expense:");

        // Create the panel for the yearly transaction amount
        JPanel yearlyTransactionAmountPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // Add the label to the panel
        yearlyTransactionAmountPanel.add(yearlyTransactionAmountLabel);

        // Create the text field for the yearly transaction amount
        JTextField yearlyTransactionAmountField = new JTextField(32);

        // Create the panel for the yearly transaction amount field
        JPanel yearlyTransactionAmountFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Add the text field to the panel
        yearlyTransactionAmountFieldPanel.add(yearlyTransactionAmountField);

        // Add the labels to the grid.
        transactionGrid.add(yearlyTransactionAmountPanel);

        transactionGrid.add(yearlyTransactionAmountFieldPanel);

        // Add the grid to the panel.
        yearlyPanel.add(transactionGrid);

        // Add a submit button to the page to submit the transaction.
        JButton submitButton = new JButton("Submit");

        // Add the submit button to the page.
        yearlyPanel.add(submitButton);

        // Call a method whenever the button is clicked.
        submitButton.addActionListener(e -> {

            // Get the text in the transaction name field.
            String transactionName = transactionNameField.getText();

            // Get the text in the yearly transaction amount field.
            String yearlyTransactionAmount = yearlyTransactionAmountField.getText();

            // Create a try/catch to catch errors from any of the fields.
            try {
                // Create a new regular transaction.
                RegularTransaction regularTransaction = new RegularTransaction(transactionName);

                // Set the hourly amount.
                regularTransaction.setYearly(-Double.parseDouble(yearlyTransactionAmount));

                // Get the current user.
                User user = UserHandler.getInstance().getUser();

                // Add the transaction to the user.
                user.addTransaction(regularTransaction);
            } catch (NumberFormatException ex) {
                // Set the segment to the popup segment, tell it to play the sound.
                new PopupSegment(
                        "Error",
                        "Please enter a valid number in each of the fields.",
                        true
                );
            }
        });

        // Return.
        return yearlyPanel;
    }

    private JPanel showMonthlyMenu() {
        JPanel monthlyPanel = new JPanel(new GridLayout(2, 1));

        JPanel transactionGrid = new JPanel(new GridLayout(2, 2));

        // Add a label & field for the transaction name.
        JLabel transactionNameLabel = new JLabel("Expense Source Name:");

        JPanel transactionNamePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        transactionNamePanel.add(transactionNameLabel);

        JTextField transactionNameField = new JTextField(32);

        JPanel transactionNameFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        transactionNameFieldPanel.add(transactionNameField);

        transactionGrid.add(transactionNamePanel);

        transactionGrid.add(transactionNameFieldPanel);

        // Create the label for the monthly transaction amount
        JLabel monthlyTransactionAmountLabel = new JLabel("Monthly Expense:");

        // Create the panel for the monthly transaction amount
        JPanel monthlyTransactionAmountPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // Add the label to the panel
        monthlyTransactionAmountPanel.add(monthlyTransactionAmountLabel);

        // Create the text field for the monthly transaction amount
        JTextField monthlyTransactionAmountField = new JTextField(32);

        // Create the panel for the monthly transaction amount field
        JPanel monthlyTransactionAmountFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Add the text field to the panel
        monthlyTransactionAmountFieldPanel.add(monthlyTransactionAmountField);

        // Add the labels to the grid.
        transactionGrid.add(monthlyTransactionAmountPanel);

        transactionGrid.add(monthlyTransactionAmountFieldPanel);

        // Add the grid to the panel.
        monthlyPanel.add(transactionGrid);

        // Add a submit button to the page to submit the transaction.
        JButton submitButton = new JButton("Submit");

        // Add the submit button to the page.
        monthlyPanel.add(submitButton);

        // Call a method whenever the button is clicked.
        submitButton.addActionListener(e -> {

            // Get the text in the transaction name field.
            String transactionName = transactionNameField.getText();

            // Get the text in the monthly transaction amount field.
            String monthlyTransactionAmount = monthlyTransactionAmountField.getText();

            // Create a try/catch to catch errors from any of the fields.
            try {
                // Create a new regular transaction.
                RegularTransaction regularTransaction = new RegularTransaction(transactionName);

                // Set the hourly amount.
                regularTransaction.setYearly(Double.parseDouble(monthlyTransactionAmount) * -12);

                // Get the current user.
                User user = UserHandler.getInstance().getUser();

                // Add the transaction to the user.
                user.addTransaction(regularTransaction);

            } catch (NumberFormatException ex) {
                // Set the segment to the popup segment, tell it to play the sound.
                new PopupSegment(
                        "Error",
                        "Please enter a valid number in each of the fields.",
                        true
                );
            }
        });

        return monthlyPanel;
    }

    private JPanel showOneTimeMenu() {
        JPanel oneTimePanel = new JPanel(new GridLayout(2, 1));

        JPanel transactionGrid = new JPanel(new GridLayout(2, 2));

        // Add a label & field for the transaction name.
        JLabel transactionNameLabel = new JLabel("Expense Source Name:");

        JPanel transactionNamePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        transactionNamePanel.add(transactionNameLabel);

        JTextField transactionNameField = new JTextField(32);

        JPanel transactionNameFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        transactionNameFieldPanel.add(transactionNameField);

        transactionGrid.add(transactionNamePanel);

        transactionGrid.add(transactionNameFieldPanel);

        // Create the label for the one time transaction amount
        JLabel oneTimeTransactionAmountLabel = new JLabel("One Time Expense:");

        // Create the panel for the one time transaction amount
        JPanel oneTimeTransactionAmountPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // Add the label to the panel
        oneTimeTransactionAmountPanel.add(oneTimeTransactionAmountLabel);

        // Create the text field for the one time transaction amount
        JTextField oneTimeTransactionAmountField = new JTextField(32);

        // Create the panel for the one time transaction amount field
        JPanel oneTimeTransactionAmountFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Add the text field to the panel
        oneTimeTransactionAmountFieldPanel.add(oneTimeTransactionAmountField);

        // Add the labels to the grid.
        transactionGrid.add(oneTimeTransactionAmountPanel);

        transactionGrid.add(oneTimeTransactionAmountFieldPanel);

        // Add the grid to the panel.
        oneTimePanel.add(transactionGrid);

        // Add a submit button to the page to submit the transaction.
        JButton submitButton = new JButton("Submit");

        // Add the submit button to the page.
        oneTimePanel.add(submitButton);

        // Call a method whenever the button is clicked.
        submitButton.addActionListener(e -> {

            // Get the text in the transaction name field.
            String transactionName = transactionNameField.getText();

            // Get the text in the one time transaction amount field.
            String oneTimeTransactionAmount = oneTimeTransactionAmountField.getText();

            // Create a try/catch to catch errors from any of the fields.
            try {
                // Create a new regular transaction.
                OneTimeTransaction oneTimeTransaction = new OneTimeTransaction(transactionName);

                // Set the hourly amount.
                oneTimeTransaction.setAmount(-Double.parseDouble(oneTimeTransactionAmount));

                // Get the current user.
                User user = UserHandler.getInstance().getUser();

                // Add the transaction to the user.
                user.addTransaction(oneTimeTransaction);

            } catch (NumberFormatException ex) {
                // Set the segment to the popup segment, tell it to play the sound.
                new PopupSegment(
                        "Error",
                        "Please enter a valid number in each of the fields.",
                        true
                );
            }
        });

        return oneTimePanel;
    }
}
