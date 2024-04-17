package javaProject.methods;

public class Expense {
    private int accountTotal;
    private int expenseAmount;

    public int addToAccount(int incomeAmount, int accountTotal){
        Transaction income= new Transaction();
        this.accountTotal += income.transactionBuy(incomeAmount, accountTotal);
        this.expenseAmount = income.transactionBuy(incomeAmount, accountTotal);
        return(this.expenseAmount);
    }
}
