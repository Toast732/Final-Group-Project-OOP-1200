package javaProject.pages;

import javax.swing.*;

public interface Page {
    public String getName();
    public void setActive();
    public JPanel getJPanel();
}
