/*
    Stores the opened windows, allowing other classes to access them.
*/

package javaProject.window;

import java.util.ArrayList;

public class WindowHandler {

    private static WindowHandler instance = null;

    private final ArrayList<BankWindow> windows;

    public WindowHandler() {
        this.windows = new ArrayList<>();
    }

    public static WindowHandler getInstance() {
        if (instance == null) {
            instance = new WindowHandler();
        }
        return instance;
    }

    public BankWindow getWindow(int index) {
        return this.windows.get(index);
    }

    public void addWindow(BankWindow window) {
        this.windows.add(window);
    }
}