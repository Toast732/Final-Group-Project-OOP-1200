package javaProject.methods;

import javaProject.debug.DebugPrint;
import javaProject.stocks.Stock;
import javaProject.transactions.OneTimeTransaction;
import javaProject.transactions.RegularTransaction;
import javaProject.transactions.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String name;
    private String familyName;
    private String email;
    public ArrayList<Transaction> transactions = new ArrayList<>();
    public ArrayList<Stock> stockTransactions = new ArrayList<>();
    private final FileIOManager onetimeTransactionManager;
    private final FileIOManager reocurringTransactionManager;

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
        this.onetimeTransactionManager = new FileIOManager(username + "_onetimeTransactions");
        this.reocurringTransactionManager = new FileIOManager(username + "_reoccurringTransactions");

        DebugPrint.info("Reading Transactions");
        this.transactions = this.readTransactions();
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

        this.writeTransaction(transaction);
    }

    public void writeTransaction(Transaction transaction){
        // Get the class this transaction is.
        String className = transaction.getClass().getName();

        // If this is a one time transaction
        if(className.equals(OneTimeTransaction.class.getName())){
            String transactionData = String.join("|", transaction.transactionName, String.valueOf(transaction.getAmount(1)));

            try {
                onetimeTransactionManager.appendToFile(transactionData); // Append to user file the new user so we don't overwrite who is there already
            } catch (IOException e) {
                System.out.println("Error saving OT transaction: " + e.getMessage());
            }
        } else if (className.equals(RegularTransaction.class.getName())) {
            String transactionData = String.join("|", transaction.transactionName, String.valueOf(transaction.getAmount(1)));

            try {
                reocurringTransactionManager.appendToFile(transactionData); // Append to user file the new user so we don't overwrite who is there already
            } catch (IOException e) {
                System.out.println("Error saving RO transaction: " + e.getMessage());
            }
        }
    }

    public ArrayList<Transaction> readTransactions() {
        List<String> oneTimeLines = onetimeTransactionManager.readFile();
        for (String line : oneTimeLines) {
            Transaction transaction = parseTransaction(line, false);
            if (transaction != null) {
                transactions.add(transaction);
            }
        }
        List<String> regularLines = reocurringTransactionManager.readFile();
        for (String line : regularLines) {
            Transaction transaction = parseTransaction(line, true);
            if (transaction != null) {
                transactions.add(transaction);
            }
        }
        return transactions;
    }
    private Transaction parseTransaction(String line, boolean isRegular) {
        String[] data = line.split("\\|");
        if (data.length < 2) {
            DebugPrint.error("Data Incomplete, line " + line);
            return null; // Transaction incomplete
        }

        String transactionName = data[0];
        double amount = Double.parseDouble(data[1]);
        Transaction transaction;

        // If these are one-time transactions
        if (!isRegular) {
            transaction = new OneTimeTransaction(transactionName);
            ((OneTimeTransaction)transaction).setAmount(amount);
            DebugPrint.info("Added One-Time Transaction with amount " + amount);

        } else {
            transaction = new RegularTransaction(transactionName);
            ((RegularTransaction) transaction).setDaily(amount);
            DebugPrint.info("Added Regular Transaction with amount " + amount);


        }

        return transaction;
    }

    public void clearTransactions() {
        // Clear the transactions
        transactions.clear();

        // Clear one time transactions
        this.clearTransaction(onetimeTransactionManager);

        // Clear reocurring transactions
        this.clearTransaction(reocurringTransactionManager);
    }

    private void clearTransaction(FileIOManager fileIOManager) {
        try {
            fileIOManager.clearFile();
        } catch (IOException e) {
            System.out.println("Error clearing transactions: " + e.getMessage());
        }
    }
}