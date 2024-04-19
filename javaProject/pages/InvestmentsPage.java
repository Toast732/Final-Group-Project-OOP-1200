package javaProject.pages;

import javaProject.pages.NormalPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InvestmentsPage extends NormalPage {

    private ArrayList<String> stockPrices;
    private int currentIndex;

    public InvestmentsPage() {
        super("Investments", new FlowLayout());

        stockPrices = new ArrayList<>();
        // Add some sample stock prices for demonstration
        stockPrices.add("$100  +10%");
        stockPrices.add("$120  +20%");
        stockPrices.add("$90  -10%");

        JPanel inputGridPanel = new JPanel(new GridLayout(3, 1));

        JLabel InvestmentLabel = new JLabel("Investments:");

        JButton StockButton = new JButton("See current stock prices");

        JLabel StockLabel = new JLabel("");

        inputGridPanel.add(InvestmentLabel);
        inputGridPanel.add(StockButton);
        inputGridPanel.add(StockLabel);
        this.jPanel.add(inputGridPanel);

        StockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < stockPrices.size()) {
                    StockLabel.setText(String.valueOf(stockPrices.get(currentIndex)));
                    currentIndex++;
                } else {
                    // Reset index if reached end of list
                    currentIndex = 0;
                }
            }
        });
    }
}
