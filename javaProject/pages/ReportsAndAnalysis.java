package javaProject.pages;

import javax.swing.*;
import java.awt.*;

public class ReportsAndAnalysis extends NormalPage{

    public ReportsAndAnalysis() {
        super("Report and Analysis", new FlowLayout());

        JPanel inputGridPanel = new JPanel(new GridLayout(3, 1));

        JLabel InvestmentLabel = new JLabel("Investments:");

        inputGridPanel.add(InvestmentLabel);
        this.jPanel.add(inputGridPanel);
    }
}
