package javaProject.accounts.users;

import javaProject.methods.User;

public class UserHandler {
    private static UserHandler instance = null;

    private User user;

    public static UserHandler getInstance() {
        if (instance == null) {
            instance = new UserHandler();
        }
        return instance;
    }

    public User getUser() {
        return this.user;
    }

    public void setCurrentUser(User user) {
        this.user = user;
    }
}
