package javaProject.pages;

import javaProject.accounts.users.UserHandler;
import javaProject.debug.DebugPrint;
import javaProject.methods.User;
import javaProject.stocks.Stock;
import javaProject.window.WindowHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.lang.Math.round;

public class InvestmentsPage extends NormalPage {
    //initiate variables
    private float stockPrice;

    private final Random random;

    private int stocksOwned;

    private JLabel stocksOwnedLabel;

    private final JPanel inputGridPanel;

    private String stockName;


    public InvestmentsPage() {
        super("Investments", new FlowLayout());
        //create page elements
        random = new Random();

        inputGridPanel = new JPanel(new GridLayout(9, 1));

        JLabel InvestmentLabel = new JLabel("Investments:");

        this.stocksOwnedLabel = new JLabel("Stocks owned:" + stocksOwned);

        JButton StockButton = new JButton("See current stock prices");

        JButton BuyStockButton = new JButton("Buy a stock at the current price current stock prices");

        JButton SellStockButton = new JButton("Sell a stock at the current stock prices");

        JTextField BuyStockLabel = new JTextField("Enter how many stocks you want to buy");

        JTextField SellStockLabel = new JTextField("Enter how many stocks you want to sell");

        JTextField StockNameLabel = new JTextField("Enter the name of the stock");

        JLabel StockLabel = new JLabel("");

        //add page elements to panel
        inputGridPanel.add(InvestmentLabel);
        inputGridPanel.add(StockButton);
        inputGridPanel.add(StockLabel);
        inputGridPanel.add(StockNameLabel);
        inputGridPanel.add(BuyStockLabel);
        inputGridPanel.add(BuyStockButton);
        inputGridPanel.add(SellStockLabel);
        inputGridPanel.add(SellStockButton);
        inputGridPanel.add(this.stocksOwnedLabel);
        this.jPanel.add(inputGridPanel);

        //create event listener that randomizes stock price
        StockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockPrice = (float) round(random.nextFloat() * 10000) /100;
                StockLabel.setText("$" + String.valueOf(stockPrice));
            }
        });
        //add event listener for when buy stock button is pressed
        BuyStockButton.addActionListener(e -> {
            try{
                if (0 > Integer.parseInt(BuyStockLabel.getText())){
                    throw new Exception();
                }
                Stock purchase = new Stock(Integer.parseInt(BuyStockLabel.getText()), stockPrice, "bought", StockNameLabel.getText());
                User user = UserHandler.getInstance().getUser();
                user.stockTransactions.add(purchase);
                stocksOwned += Integer.parseInt(BuyStockLabel.getText());
                WindowHandler.getInstance().getWindow(0).update();
                DebugPrint.info("New Stock Count: " + stocksOwned);
                this.inputGridPanel.remove(this.stocksOwnedLabel);
                this.stocksOwnedLabel = new JLabel("Stocks Owned: " + stocksOwned);
                this.inputGridPanel.add(this.stocksOwnedLabel);

            }
            catch(Exception a){
                BuyStockLabel.setText("Please insert a number before buying stocks");
            }
        });
        //add event listener for when sell stock button is clicked
        SellStockButton.addActionListener(e -> {
            try{
                if (stocksOwned < Integer.parseInt(SellStockLabel.getText())){
                    throw new Exception();
                }
                if (0 > Integer.parseInt(SellStockLabel.getText())){
                    throw new Exception();
                }
                Stock sell = new Stock(Integer.parseInt(SellStockLabel.getText()), stockPrice, "sold", StockNameLabel.getText());
                User user = UserHandler.getInstance().getUser();
                user.stockTransactions.add(sell);
                stocksOwned -= Integer.parseInt(SellStockLabel.getText());
                WindowHandler.getInstance().getWindow(0).update();
                DebugPrint.info("New Stock Count: " + stocksOwned);
                this.inputGridPanel.remove(this.stocksOwnedLabel);
                this.stocksOwnedLabel = new JLabel("Stocks Owned: " + stocksOwned);
                this.inputGridPanel.add(this.stocksOwnedLabel);
            }
            catch(Exception a){
                BuyStockLabel.setText("Please insert a number before selling stocks");
            }
        });
    }
}
