package javaProject.pages;

import javaProject.methods.FileIOManager;
import javaProject.methods.User;
import javax.swing.*;
import java.awt.*;

public class TransactionHistory extends NormalPage {
    private FileIOManager fileManager;

    public TransactionHistory() {
        super("Transaction history", new FlowLayout());

        JPanel inputGridPanel = new JPanel(new GridLayout(3, 1));

        JLabel InvestmentLabel = new JLabel("Investments:");

        inputGridPanel.add(InvestmentLabel);
        this.jPanel.add(inputGridPanel);

    }
}
