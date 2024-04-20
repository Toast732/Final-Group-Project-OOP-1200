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
import java.awt.*;
import java.util.Objects;

public class DashboardPage extends NormalPage {

    private JPanel dashboardPanel;

    private static final double daysPerMonth = (double) 365 / 12;

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
        this.dashboardPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

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

        // Create a 3x1 grid and add it to the dashboard panel, for the pi charts.
        JTabbedPane pieTabber = new JTabbedPane();

        // Iterate through all the user's transactions.
        for (int i = 0; i < user.transactions.size(); i++) {

            // Get the transaction.
            Transaction transaction = user.transactions.get(i);

            // Get the amount based upon the last 30 days
            double amount = transaction.getAmount(daysPerMonth);

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

        // Create a pie chart of the income via JFreeChart.
        JFreeChart incomeChart = ChartFactory.createPieChart("Income (Last 30 days)", createIncomeDataset(user), true, true, false);

        // Create a pie chart via JFreeChart with the running expenses and income.
        JFreeChart grossChart = ChartFactory.createPieChart("Monthly Balance Report (Last 30 days)", createGrossDataset(runningExpenses, runningIncome), true, true, false);

        // Create a pie chart of the expenses via JFreeChart.
        JFreeChart expensesChart = ChartFactory.createPieChart("Expenses (Last 30 days)", createExpensesDataset(user), true, true, false);

        // Create a gross chart panel to display the chart.
        ChartPanel grossPanel = new ChartPanel(grossChart);

        // Create an income chart panel to display the chart.
        ChartPanel incomePanel = new ChartPanel(incomeChart);

        // Create an expenses chart panel to display the chart.
        ChartPanel expensesPanel = new ChartPanel(expensesChart);

        // Add the chart panel to the pieTabber.
        pieTabber.add("Gross Profit", grossPanel);

        // Add the income chart panel to the pieTabber.
        pieTabber.add("Income", incomePanel);

        // Add the expenses chart panel to the pieTabber.
        pieTabber.add("Expenses", expensesPanel);

        // Add the grid to the dashboard panel.
        this.dashboardPanel.add(pieTabber);

        // Add the dashboard panel to the main panel.
        this.jPanel.add(this.dashboardPanel);
    }

    private PieDataset<String> createIncomeDataset(User user) {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();

        // Iterate through all the user's transactions.
        for (Transaction transaction : user.transactions) {
            // Get the amount based upon the last 30 days
            double amount = transaction.getAmount(daysPerMonth);

            // If the type is an income, add it to the dataset.
            if (Objects.equals(transaction.transactionType, "Income")) {
                dataset.setValue(transaction.transactionName, amount);
            }
        }

        return dataset;
    }

    private PieDataset<String> createGrossDataset(double runningExpenses, double runningIncome) {
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

    private PieDataset<String> createExpensesDataset(User user) {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();

        // Iterate through all the user's transactions.
        for (Transaction transaction : user.transactions) {
            // Get the amount based upon the last month
            double amount = -transaction.getAmount(daysPerMonth);

            // If the type is an income, add it to the dataset.
            if (Objects.equals(transaction.transactionType, "Expense")) {
                dataset.setValue(transaction.transactionName, amount);
            }
        }

        return dataset;
    }
}
