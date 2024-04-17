package javaProject.methods;

public class Withdraw {
    private int accountTotal;
    private int expenseAmount;

    public int generateWithdraw(int depositAmount, int accountTotal){
        Transaction income= new Transaction();
        this.expenseAmount = income.transactionBuy(depositAmount, accountTotal);
        return(this.expenseAmount);
    }

    public int updateAccountTotal(int withdrawAmount, int accountTotal){
        Transaction income= new Transaction();
        this.accountTotal += income.transactionBuy(withdrawAmount, accountTotal);
        return(this.accountTotal);
    }
}
