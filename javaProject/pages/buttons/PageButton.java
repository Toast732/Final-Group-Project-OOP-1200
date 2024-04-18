package javaProject.pages.buttons;

import javax.swing.*;

abstract public class PageButton {
    public final JButton button;
    private final String name;

    public PageButton(String name) {
        this.name = name;

        // Create a new JButton with the name of the button.
        this.button = new JButton(name);

        // Add an action listener to the button.
        this.button.addActionListener(e -> onClick());
    }

    public String getName() {
        return this.name;
    }

    abstract public void onClick();
}
