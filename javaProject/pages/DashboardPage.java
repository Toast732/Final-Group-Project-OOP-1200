package javaProject.pages;

import javaProject.accounts.users.UserHandler;
import javaProject.debug.DebugPrint;
import javaProject.methods.User;
import javaProject.transactions.Transaction;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

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
                runningExpenses += amount;
            } else {
                // If the type is an income, add it to the running income.
                runningIncome += amount;
            }

            DebugPrint.info("Transaction: " + transaction.transactionName + " Amount: " + amount);
        }

        // Create a barchart via JFreeChart with the running expenses and income.
        JFreeChart barChart = ChartFactory.createBarChart("Monthly Balance Report", "Type", "Amount", createDataset(runningExpenses, runningIncome), PlotOrientation.VERTICAL, true, true, false);

        // Create a chart panel with the barchart.
        ChartPanel chartPanel = new ChartPanel(barChart);

        // Add the chart panel to the dashboard panel.
        this.dashboardPanel.add(chartPanel);

        // Add the dashboard panel to the page.
        this.jPanel.add(this.dashboardPanel);
    }

    private CategoryDataset createDataset(double runningExpenses, double runningIncome) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(-runningExpenses, "Expenses", "Expenses");
        dataset.addValue(runningIncome, "Income", "Income");

        return dataset;
    }
}
