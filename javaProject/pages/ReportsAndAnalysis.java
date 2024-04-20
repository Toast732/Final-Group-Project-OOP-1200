package javaProject.pages;

import javaProject.accounts.users.UserHandler;
import javaProject.methods.User;
import javaProject.stocks.Stock;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReportsAndAnalysis extends NormalPage{

    private JPanel dashboardPanel;

    public ReportsAndAnalysis(JTabbedPane jTabbedPane) {
        super("Report and Analysis", new FlowLayout());

        // Refresh the page
        this.refresh();

        jTabbedPane.addChangeListener(e -> {
            if (jTabbedPane.getSelectedComponent() == this.jPanel) {
                refresh();
            }
        });

    }
    //create an empty graph
    public ChartPanel barChart(String chartTitle) {
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Transactions",
                "Number",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setPreferredSize(new Dimension( 560 , 367 ) );

        return chartPanel;
    }

    private CategoryDataset createDataset( ) {
        User user = UserHandler.getInstance().getUser();

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Map<String, ArrayList<Stock>> splitStocks = new HashMap<>();

        for (int i = 0; i < user.stockTransactions.size(); i++) {
            Stock stock = user.stockTransactions.get(i);

            final String first = stock.stockName;

            if(!splitStocks.containsKey(first)){
                splitStocks.put(first, new ArrayList<>());
            }
            splitStocks.get(first).add(stock);
        }

        //create a new entry into the graph
        for (Map.Entry<String, ArrayList<Stock>> entry : splitStocks.entrySet()){
            ArrayList<Stock> stocks = entry.getValue();
            for (int stock_index = 0; stock_index < stocks.size(); stock_index++) {
                // Get the stock
                Stock stock = stocks.get(stock_index);
                //add two bars to the graph
                dataset.addValue(stock.stockPrice, stock.transactionType, stock.stockName + " : Cost");
                dataset.addValue(stock.numberOfStock, stock.transactionType, stock.stockName + " : Stock Purchased");
            }
        }

        return dataset;
    }

    private void refresh() {

        // If the dashboard panel is not null, remove it.
        if (this.dashboardPanel != null) {
            this.jPanel.remove(this.dashboardPanel);
        }

        // Create a new dashboard panel.
        this.dashboardPanel = new JPanel();

        // Add the dashboard panel to the main panel.
        this.jPanel.add(this.dashboardPanel);

        //create page elements
        User user = UserHandler.getInstance().getUser();

        JPanel inputGridPanel = new JPanel(new GridLayout(9, 1));

        // Add the grid to the dashboard panel
        this.dashboardPanel.add(inputGridPanel);

        JLabel investmentLabel = new JLabel("Investment statement");

        JLabel numberOfTransactionsLabel = new JLabel("you have made " + user.stockTransactions.size() + " stock transactions");

        //arrange page elements in proper order
        inputGridPanel.add(investmentLabel);
        inputGridPanel.add(numberOfTransactionsLabel);

        // Create the bar chart, and add it to the dashboard panel.
        this.dashboardPanel.add(this.barChart("Stock Transactions"));
    }
}
