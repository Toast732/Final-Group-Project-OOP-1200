package javaProject.pages;

import javaProject.accounts.users.UserHandler;
import javaProject.debug.DebugPrint;
import javaProject.methods.User;
import javaProject.transactions.Transaction;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import java.util.Objects;

public class DashboardPage extends NormalPage {

    private JPanel dashboardPanel;

    public DashboardPage(JTabbedPane jTabbedPane) {
        // Create the page for this, and call it "Dashboard"
        super("Dashboard");

        jTabbedPane.addChangeListener(e -> {
            if (jTabbedPane.getSelectedComponent() == this.jPanel) {
                refresh();
            }
        });
    }

    public void refresh() {

        // If the dashboard panel is not null, remove it.
        if (this.dashboardPanel != null) {
            this.jPanel.remove(this.dashboardPanel);
        }

        // Create a new dashboard panel.
        this.dashboardPanel = new JPanel();

        // Get the current user.
        User user = UserHandler.getInstance().getUser();

        // Store the current running amount.
        double runningExpenses = 0;
        double runningIncome = 0;

        // If the user has no transactions,just put a label saying they should add some.
        if (user.transactions.isEmpty()) {
            this.dashboardPanel.add(new JLabel("You have no transactions. Add some to see a report."));
            this.jPanel.add(this.dashboardPanel);
            return;
        }

        // Iterate through all the user's transactions.
        for (int i = 0; i < user.transactions.size(); i++) {

            // Get the transaction.
            Transaction transaction = user.transactions.get(i);

            // Get the amount based upon the last 30 days
            double amount = transaction.getAmount(30);

            // Add the amount to the running total.
            // If the type is an expense, add it to the running expenses.
            if (Objects.equals(transaction.transactionType, "Expense")) {
                runningExpenses += Math.abs(amount);
            } else {
                // If the type is an income, add it to the running income.
                runningIncome += amount;
            }

            DebugPrint.info("Transaction: " + transaction.transactionName + " Amount: " + amount);
        }

        // Create a barchart via JFreeChart with the running expenses and income.
        JFreeChart barChart = ChartFactory.createPieChart("Monthly Balance Report", createDataset(runningExpenses, runningIncome), true, true, false);

        // Create a chart panel to display the chart.
        ChartPanel chartPanel = new ChartPanel(barChart);

        // Add the chart panel to the dashboard panel.
        this.dashboardPanel.add(chartPanel);

        // Add the dashboard panel to the main panel.
        this.jPanel.add(this.dashboardPanel);
    }

    private PieDataset<String> createDataset(double runningExpenses, double runningIncome) {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();

        if (runningExpenses > 0) {
            dataset.setValue("Expenses", runningExpenses);
        }

        // Get the gross profit.
        double grossProfit = runningIncome - runningExpenses;

        if (grossProfit > 0) {
            dataset.setValue("Gross Profit", grossProfit);
        }

        return dataset;
    }
}
