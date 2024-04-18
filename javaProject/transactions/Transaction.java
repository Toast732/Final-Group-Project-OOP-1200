package javaProject.transactions;

abstract class Transaction {
    public String transactionName;

    abstract public double getAmount(int days);
}
