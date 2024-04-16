package javaProject.methods;

public class Income {
    private int accountTotal;
    private int incomeAmount;

    public int addToAccount(int incomeAmount, int accountTotal){
        Transaction income= new Transaction();
        this.accountTotal += income.transactionEarn(incomeAmount, accountTotal);
        this.incomeAmount = income.transactionEarn(incomeAmount, accountTotal);
        return(this.incomeAmount);
    }
}
