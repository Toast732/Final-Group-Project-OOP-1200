package javaProject.pages;

import javax.swing.*;
import java.awt.*;

public interface Page {
    public String getName();
    public void setActive();
    public JPanel getJPanel();
}
