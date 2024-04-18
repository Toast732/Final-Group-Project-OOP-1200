package javaProject.methods.FinancialElements;

public class Withdraw extends ManageFinances{
    private float accountTotal;
    private float expenseAmount;

    public float generateWithdraw(float withdrawAmount, float accountTotal){
        Transaction withdraw= new Transaction();
        float totalFunds = accountBalance;
        if (withdrawAmount > totalFunds){
            System.out.println("you are attempting to withdraw more funds than you currently posses");
            return(0);
        }
        else{
            this.expenseAmount = withdraw.transactionBuy(withdrawAmount, accountTotal);
            updateAccountTotal(withdrawAmount, accountTotal);
            return(this.expenseAmount);
        }
    }

    public float updateAccountTotal(float withdrawAmount, float accountTotal){
        Transaction income= new Transaction();
        this.accountTotal += income.transactionBuy(withdrawAmount, accountTotal);
        return(this.accountTotal);
    }
}
