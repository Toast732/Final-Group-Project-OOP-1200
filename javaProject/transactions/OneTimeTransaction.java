package javaProject.transactions;

public class OneTimeTransaction extends Transaction{

    private double singleAmount;
    public String transactionType;
    @Override
    public double getAmount(int days) {
        return 0;
    }
    private void setAmount(Double amount){
        this.singleAmount = amount;
        if (this.singleAmount >= 0) {
            this.transactionType = "Income";
        } else {
            this.transactionType = "Expense";
        }
    }

}
