package javaProject.methods.FinancialElements;

public class Deposit {
    private float accountTotal;
    private float incomeAmount;

    public float generateDeposit(float depositAmount, float accountTotal){
        Transaction deposit= new Transaction();
        this.incomeAmount = deposit.transactionEarn(depositAmount, accountTotal);
        updateAccountTotal(depositAmount, accountTotal);
        return(this.incomeAmount);
    }

    public void updateAccountTotal(float depositAmount, float accountTotal){
        Transaction income= new Transaction();
        this.accountTotal += income.transactionEarn(depositAmount, accountTotal);
    }
}
