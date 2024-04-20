package javaProject.transactions;

public class OneTimeTransaction extends Transaction{

    private double singleAmount;

    public OneTimeTransaction(String transactionName) {
        this.transactionName = transactionName;
    }

    @Override
    public double getAmount(double days) {
        return this.singleAmount;
    }

    public void setAmount(Double amount){
        this.singleAmount = amount;
        if (this.singleAmount >= 0) {
            this.transactionType = "Income";
        } else {
            this.transactionType = "Expense";
        }
    }

    public void setTitle(String name){
        this.transactionName = name;
    }

}
