package javaProject.methods;

import javaProject.stocks.Stock;
import javaProject.transactions.Transaction;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String name;
    private String familyName;
    private String email;
    public ArrayList<Transaction> transactions = new ArrayList<>();
    public ArrayList<Stock> stockTransactions = new ArrayList<>();

    public User(
            String username,
            String password,
            String name,
            String familyName,
            String email

    ) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.familyName = familyName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getEmail() {
        return email;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}