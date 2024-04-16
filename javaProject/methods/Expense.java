package javaProject.methods;

public class Expense {
    private int accountTotal;
    private int expenseAmount;

    public int generateExpense(int incomeAmount, int accountTotal){
        Transaction income= new Transaction();
        this.expenseAmount = income.transactionBuy(incomeAmount, accountTotal);
        return(this.expenseAmount);
    }

    public int updateAccountTotal(int incomeAmount, int accountTotal){
        Transaction income= new Transaction();
        this.accountTotal += income.transactionBuy(incomeAmount, accountTotal);
        return(this.accountTotal);
    }
}
