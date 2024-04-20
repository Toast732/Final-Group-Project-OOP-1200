package javaProject.pages;

import javaProject.accounts.users.UserHandler;
import javaProject.external.table.ButtonColumn;
import javaProject.methods.User;
import javaProject.transactions.RegularTransaction;
import javaProject.transactions.Transaction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditTransactionsPage extends NormalPage {

    private JPanel editTransactionsPanel;

    public EditTransactionsPage(JTabbedPane jTabbedPane) {
        // Create the page for this, and call it "Edit Transactions"
        super("Edit Transactions", new FlowLayout());

        jTabbedPane.addChangeListener(e -> {
            if (jTabbedPane.getSelectedComponent() == this.jPanel) {
                refresh();
            }
        });
    }

    private void refresh() {
        // If the edit transactions panel is not null, remove it.
        if (this.editTransactionsPanel != null) {
            this.jPanel.remove(this.editTransactionsPanel);
        }

        // Create a panel for the page.
        this.editTransactionsPanel = new JPanel();

        // Add the panel to the page.
        this.jPanel.add(this.editTransactionsPanel);

        // Create a grid for the table to go on.
        JPanel grid = new JPanel();

        // Add the grid to the panel.
        this.editTransactionsPanel.add(grid);

        // Get the current user.
        User user = UserHandler.getInstance().getUser();

        // Create the list of titles.
        String[] titles = {"Name", "Income/Expense", "Reoccurring", "Amount (Per Day)", "Delete"};

        // Populate the title row.
        //grid.add(this.createTitleLabel("Transaction Name"));
        //grid.add(this.createTitleLabel(" Income/Expense "));
        //grid.add(this.createTitleLabel(" Is Reoccurring?"));
        //grid.add(this.createTitleLabel("Amount (Per Day)"));

        // Create the list of fields.
        String[][] fields = new String[user.transactions.size()][5];


        // Populate the transactions.
        for (int i = 0; i < user.transactions.size(); i++) {
            // Get the transaction.
            Transaction transaction = user.transactions.get(i);

            // Create the transaction name field.
            fields[i][0] = transaction.transactionName;

            // Create the income/expense field.
            fields[i][1] = transaction.transactionType;

            // Create the reoccurring field.
            if (transaction instanceof RegularTransaction) {
                fields[i][2] = "Yes";
            } else {
                fields[i][2] = "No";
            }

            // Create the amount field.
            fields[i][3] = Double.toString(Math.round(Math.abs(transaction.getAmount(1)) * 100) / 100.0);

            fields[i][4] = "Delete Transaction";
        }

        // Create the JTable model.
        DefaultTableModel model = new DefaultTableModel(fields, titles);

        // Create the JTable.
        JTable table = new JTable(model);

        table.setPreferredSize(new Dimension(1920, 1080));

        // Add the table to the grid.
        JScrollPane scrollPane = new JScrollPane(table);

        // Adapted From: https://tips4java.wordpress.com/2009/07/12/table-button-column/
        Action delete = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.parseInt(e.getActionCommand());
                model.removeRow(modelRow);
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(table, delete, 4);
        buttonColumn.setMnemonic(KeyEvent.VK_D);

        // Get the screen's size.
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Get the dimensions we want to use
        Dimension dimensions = new Dimension((int) (screenSize.getWidth() * 0.85), (int) (screenSize.getHeight() * 0.8));

        // Set the preferred size of the scroll pane.
        scrollPane.setPreferredSize(dimensions);

        // Add the scroll pane to the grid.
        grid.add(scrollPane);

        // Set the size of the grid.
        grid.setPreferredSize(dimensions);

        // Create a save button.
        JButton saveButton = new JButton("Save");

        // Add the save button to the panel.
        this.editTransactionsPanel.add(saveButton);

        // Add an action listener to the save button.
        saveButton.addActionListener(e -> {
            // Clear the transactions.
            user.transactions.clear();

            // Iterate through all the rows in the table.
            for (int i = 0; i < table.getRowCount(); i++) {
                // Get the transaction name.
                String transactionName = (String) table.getValueAt(i, 0);

                // Get the transaction type.
                String transactionType = (String) table.getValueAt(i, 1);

                // Get the transaction amount.
                double transactionAmount = Double.parseDouble((String) table.getValueAt(i, 3));

                // If the transaction type is an expense, make the amount negative.
                if (transactionType.equals("Expense")) {
                    transactionAmount = -transactionAmount;
                }

                // If the transaction is reoccurring, create a regular transaction.
                if (table.getValueAt(i, 2).equals("Yes")) {
                    // Create the regular transaction.
                    //RegularTransaction regularTransaction = new RegularTransaction(transactionName, transactionType, transactionAmount);

                    // Add the transaction to the user.
                    //user.addTransaction(regularTransaction);

                    // Continue to the next iteration.
                    //continue;
                }

                // Create the transaction.
                //Transaction transaction = new Transaction(transactionName, transactionType, transactionAmount);

                // Add the transaction to the user.
                //user.addTransaction(transaction);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {

    }
}