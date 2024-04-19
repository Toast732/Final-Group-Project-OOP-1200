package javaProject.transactions;

public abstract class Transaction {
    public String transactionName;

    abstract public double getAmount(int days);
}