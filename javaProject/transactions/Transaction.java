package javaProject.transactions;

public abstract class Transaction {
    public String transactionName;
    public String transactionType;

    abstract public double getAmount(int days);
}