package javaProject.transactions;

public class OneTimeTransaction extends Transaction{

    private double singleAmount;
    @Override
    public double getAmount(int days) {
        return 0;
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
