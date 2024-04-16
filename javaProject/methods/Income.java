package javaProject.methods;

public class Income {
    private int accountTotal;
    private int incomeAmount;

    public int generateIncome(int incomeAmount, int accountTotal){
        Transaction income= new Transaction();
        this.incomeAmount = income.transactionEarn(incomeAmount, accountTotal);
        return(this.incomeAmount);
    }

    public int updateAccountTotal(int incomeAmount, int accountTotal){
        Transaction income= new Transaction();
        this.accountTotal += income.transactionEarn(incomeAmount, accountTotal);
        return(this.accountTotal);
    }
}
