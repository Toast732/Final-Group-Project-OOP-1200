package javaProject.pages;

import javaProject.accounts.users.UserHandler;
import javaProject.debug.DebugPrint;
import javaProject.methods.User;
import javaProject.pageSegments.PopupSegment;
import javaProject.stocks.Stock;

import javax.swing.*;
import java.awt.*;

public class InvestmentsPage extends NormalPage {
    //initiate variables
    private float stockPrice;

    private int stocksOwned;

    private JLabel stocksOwnedLabel;

    private final JPanel inputGridPanel;

    private String stockName;

    public InvestmentsPage() {
        super("Manage Buying & Selling Stocks", new FlowLayout());
        //create page elements

        inputGridPanel = new JPanel(new GridLayout(0, 2));

        // Get the total stocks owned.
        User user = UserHandler.getInstance().getUser();

        for (int i = 0; i < user.stockTransactions.size(); i++) {
            Stock stock = user.stockTransactions.get(i);
            if (stock.transactionType.equals("Buy")) {
                stocksOwned += stock.numberOfStock;
            } else {
                stocksOwned -= stock.numberOfStock;
            }
        }

        this.stocksOwnedLabel = new JLabel("Stocks owned:" + stocksOwned);

        // Create a field to input the stock name
        JLabel stockNameLabel = new JLabel("Stock Name");

        // Create a field to input the stock name
        JTextField stockNameField = new JTextField(32);

        // Create a field to input the stock price
        JLabel StockLabel = new JLabel("Stock Price");

        // Create a field to input the stock price
        JTextField StockButton = new JTextField(32);

        // Create a field to input the number of stocks to buy
        JLabel InputCountLabel = new JLabel("Number of Stocks to Buy/Sell");

        // Create a field to input the number of stocks to sell
        JTextField InputCountField = new JTextField(32);

        // Create a button to buy stocks
        JButton BuyStockButton = new JButton("Buy Stocks");

        // Create a button to sell stocks
        JButton SellStockButton = new JButton("Sell Stocks");

        //add page elements to panel
        this.inputGridPanel.add(stockNameLabel);
        this.inputGridPanel.add(stockNameField);
        this.inputGridPanel.add(StockLabel);
        this.inputGridPanel.add(StockButton);
        this.inputGridPanel.add(InputCountLabel);
        this.inputGridPanel.add(InputCountField);
        this.inputGridPanel.add(BuyStockButton);
        this.inputGridPanel.add(SellStockButton);
        this.inputGridPanel.add(this.stocksOwnedLabel);
        this.jPanel.add(inputGridPanel);

        //add action listeners to buttons
        BuyStockButton.addActionListener(e -> {

            try {

                // Get the amount to buy.
                int amountToBuy = Integer.parseInt(InputCountField.getText());
                //get the stock name
                stockName = stockNameField.getText();
                //get the stock price
                stockPrice = Float.parseFloat(StockButton.getText());
                //get the number of stocks to buy
                stocksOwned += amountToBuy;
                //update the stocks owned label
                this.stocksOwnedLabel.setText("Stocks owned:" + stocksOwned);
                //add the stock to the user's stock list
                UserHandler.getInstance().getUser().addStock(new Stock(amountToBuy, stockPrice, "Buy", stockName));
            } catch (NumberFormatException ex) {
                DebugPrint.error("Error parsing stock price: " + ex.getMessage());
                new PopupSegment("Error", "Please make sure all fields have valid inputs.", true);
            }
        });

        SellStockButton.addActionListener(e -> {
            try {

                //get the stock name
                stockName = stockNameField.getText();

                // See if they have enough of this stock
                int amountOfThisStock = 0;

                for (int i = 0; i < user.stockTransactions.size(); i++) {
                    Stock stock = user.stockTransactions.get(i);

                    // If this stock is the desired type, and the stock was bought, add it to the total.
                    if (stock.stockName.equals(stockName) && stock.transactionType.equals("Buy")) {
                        amountOfThisStock += stock.numberOfStock;
                    } else if (stock.stockName.equals(stockName) && stock.transactionType.equals("Sell")) {
                        amountOfThisStock -= stock.numberOfStock;
                    }
                }

                DebugPrint.info("Amount of this stock: " + amountOfThisStock);

                // Get the amount stock they want to sell.
                int amountToSell = Integer.parseInt(InputCountField.getText());

                if (amountOfThisStock < amountToSell) {
                    new PopupSegment("Error", "You do not have enough of this stock to sell.", true);
                    return;
                }

                //get the stock price
                stockPrice = Float.parseFloat(StockButton.getText());
                //get the number of stocks to sell
                stocksOwned -= amountToSell;
                //update the stocks owned label
                this.stocksOwnedLabel.setText("Stocks owned:" + stocksOwned);
                //add the stock to the user's stock list
                UserHandler.getInstance().getUser().addStock(new Stock(amountToSell, stockPrice, "Sell", stockName));
            } catch (Exception ex) {
                DebugPrint.error("Error parsing stock price: " + ex.getMessage());
                new PopupSegment("Error", "Please make sure all fields have valid inputs.", true);
            }
        });

    }
}
