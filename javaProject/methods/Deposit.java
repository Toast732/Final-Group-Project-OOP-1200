package javaProject.methods;

public class Deposit {
    private int accountTotal;
    private int incomeAmount;

    public int generateDeposit(int depositAmount, int accountTotal){
        Transaction income= new Transaction();
        this.incomeAmount = income.transactionEarn(depositAmount, accountTotal);
        return(this.incomeAmount);
    }

    public int updateAccountTotal(int depositAmount, int accountTotal){
        Transaction income= new Transaction();
        this.accountTotal += income.transactionEarn(depositAmount, accountTotal);
        return(this.accountTotal);
    }
}
