package javaProject.pages;

import javaProject.accounts.users.UserHandler;
import javaProject.methods.User;
import javaProject.pageSegments.PopupSegment;
import javaProject.panels.DropdownPanel;
import javaProject.transactions.RegularTransaction;

import javax.swing.*;
import java.awt.*;

public class AddRegularTransactionPage extends NormalPage {

    public AddRegularTransactionPage() {
        super("Add Regular Transaction", new FlowLayout());

        // Create the dropdown panel
        DropdownPanel transactionTypeDropdownPanel = new DropdownPanel("Transaction Type:");

        // Add the items to the dropdown
        transactionTypeDropdownPanel.addDropdownItem("Yearly", this::showYearlyMenu);

        transactionTypeDropdownPanel.addDropdownItem("Hourly", this::showHourlyMenu);

        this.jPanel.add(transactionTypeDropdownPanel);
    }

    // Show the yearly menu
    private JPanel showYearlyMenu() {

        JPanel yearlyPanel = new JPanel(new GridLayout(2, 1));

        JPanel transactionGrid = new JPanel(new GridLayout(1, 2));

        // Create the label for the yearly transaction amount
        JLabel yearlyTransactionAmountLabel = new JLabel("Yearly Transaction Amount:");

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

        // Return.
        return yearlyPanel;
    }

    private JPanel showHourlyMenu() {

        JPanel hourlyPanel = new JPanel(new GridLayout(2, 1));

        JPanel transactionGrid = new JPanel(new GridLayout(3, 2));

        // Add a label & field for the transaction name.
        JLabel transactionNameLabel = new JLabel("Transaction Name:");

        JPanel transactionNamePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        transactionNamePanel.add(transactionNameLabel);

        JTextField transactionNameField = new JTextField(32);

        JPanel transactionNameFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        transactionNameFieldPanel.add(transactionNameField);

        transactionGrid.add(transactionNamePanel);

        transactionGrid.add(transactionNameFieldPanel);

        // Create the label for the hourly transaction amount
        JLabel hoursWorkedAWeekLabel = new JLabel("Hours Worked a Week:");

        // Create the panel for the hourly transaction amount
        JPanel hoursWorkedAWeekPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // Add the label to the panel
        hoursWorkedAWeekPanel.add(hoursWorkedAWeekLabel);

        // Create the text field for the hourly transaction amount
        JTextField hoursWorkedAWeekField = new JTextField(32);

        // Create the panel for the hourly transaction amount field
        JPanel hoursWorkedAWeekFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Add the text field to the panel
        hoursWorkedAWeekFieldPanel.add(hoursWorkedAWeekField);

        // Add the labels to the grid.

        transactionGrid.add(hoursWorkedAWeekPanel);

        transactionGrid.add(hoursWorkedAWeekFieldPanel);

        // Create the label for the hourly transaction amount
        JLabel hourlyRateLabel = new JLabel("Hourly Rate:");

        // Create the panel for the hourly transaction amount
        JPanel hourlyRatePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // Add the label to the panel
        hourlyRatePanel.add(hourlyRateLabel);

        // Create the text field for the hourly transaction amount
        JTextField hourlyRateField = new JTextField(32);

        // Create the panel for the hourly transaction amount field
        JPanel hourlyRateFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Add the text field to the panel
        hourlyRateFieldPanel.add(hourlyRateField);

        // Add the labels to the grid.
        transactionGrid.add(hourlyRatePanel);

        transactionGrid.add(hourlyRateFieldPanel);

        // Add the grid to the panel.
        hourlyPanel.add(transactionGrid);

        // Add a submit button to the page to submit the transaction.
        JButton submitButton = new JButton("Submit");

        // Add the submit button to the page.
        hourlyPanel.add(submitButton);

        // Call a method whenever the button is clicked.
        submitButton.addActionListener(e -> {

            // Get the text in the transaction name field.
            String transactionName = transactionNameField.getText();

            // Get the text in the hours worked a week field.
            String hoursWorkedAWeek = hoursWorkedAWeekField.getText();

            // Get the text in the hourly rate field.
            String hourlyRate = hourlyRateField.getText();

            // Create a try/catch to catch errors from any of the fields.
            try {
                // Create a new regular transaction.
                RegularTransaction regularTransaction = new RegularTransaction(transactionName);

                // Set the hourly amount.
                regularTransaction.setHourly(Double.parseDouble(hoursWorkedAWeek), Double.parseDouble(hourlyRate));

                // Get the current user.
                User user = UserHandler.getInstance().getUser();

                // Add the transaction to the user.
                user.transactions.add(regularTransaction);
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
        return hourlyPanel;
    }
}
