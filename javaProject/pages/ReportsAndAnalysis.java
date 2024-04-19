package javaProject.pages;

import javaProject.accounts.users.UserHandler;
import javaProject.methods.User;
import javaProject.stocks.Stock;

import javax.swing.*;
import java.awt.*;

public class ReportsAndAnalysis extends NormalPage{

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
        });
    }
}
