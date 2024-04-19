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
    private float currentPrice;
    private int currentSaleAmount;
    private String currentType;
    private String currentName;

    public ReportsAndAnalysis() {
        super("Report and Analysis", new FlowLayout());

        User user = UserHandler.getInstance().getUser();

        JPanel inputGridPanel = new JPanel(new GridLayout(9, 1));

        JLabel investmentLabel = new JLabel("Investment statement");

        JLabel numberOfTransactionsLabel = new JLabel("you have made " + user.stockTransactions.size() + " stock transactions");

        JLabel recentTransactionAmountLabel = new JLabel("you haven't bought or sold any stock");

        JLabel recentTransactionPriceLabel = new JLabel("you haven't bought or sold any stock");

        JButton refreshButton = new JButton("Refresh page");

        inputGridPanel.add(investmentLabel);
        inputGridPanel.add(numberOfTransactionsLabel);
        inputGridPanel.add(recentTransactionAmountLabel);
        inputGridPanel.add(recentTransactionPriceLabel);
        inputGridPanel.add(refreshButton);
        this.jPanel.add(inputGridPanel);

        refreshButton.addActionListener(e -> {
            numberOfTransactionsLabel.setText("you have made " + user.stockTransactions.size() + " stock transactions");
            recentTransactionAmountLabel.setText("you last " + user.stockTransactions.getLast().transactionType +" "+ user.stockTransactions.getLast().numberOfStock + " stock");
            recentTransactionPriceLabel.setText("you last " + user.stockTransactions.getLast().transactionType +" for "+ user.stockTransactions.getLast().stockPrice + " dollars");
            this.barChart("Yes");
        });

        for (int i = 0; i < user.stockTransactions.size(); i++) {
            this.currentPrice = user.stockTransactions.get(i).stockPrice;
            this.currentSaleAmount = user.stockTransactions.get(i).numberOfStock;
            this.currentType = user.stockTransactions.get(i).transactionType;
        }

        //this.barChart("Yes");

    }
    public void barChart(String chartTitle) {
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Transactions",
                "Number",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setPreferredSize(new Dimension( 560 , 367 ) );
        this.jPanel.add(chartPanel);
    }

    private CategoryDataset createDataset( ) {
        User user = UserHandler.getInstance().getUser();

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Map<String, ArrayList<Stock>> splitStocks = new HashMap<>();

        for (int i = 0; i < user.stockTransactions.size(); i++) {
            Stock stock = user.stockTransactions.get(i);
            this.currentPrice = user.stockTransactions.get(i).stockPrice;
            this.currentSaleAmount = user.stockTransactions.get(i).numberOfStock;
            this.currentType = user.stockTransactions.get(i).transactionType;
            this.currentName = user.stockTransactions.get(i).stockName;

            final String first = this.currentName;

            if(!splitStocks.containsKey(first)){
                splitStocks.put(first, new ArrayList<>());
            }
            splitStocks.get(first).add(stock);
        }

        for (Map.Entry<String, ArrayList<Stock>> entry : splitStocks.entrySet()){
            ArrayList<Stock> stocks = entry.getValue();
            for (int stock_index = 0; stock_index < stocks.size(); stock_index++) {
                // Get the stock
                Stock stock = stocks.get(stock_index);

                dataset.addValue(stock.stockPrice, stock.transactionType, stock.stockName+": Cost");
                dataset.addValue(stock.numberOfStock, stock.transactionType, stock.stockName+": number purchased");
            }
        }

        return dataset;
    }
}
