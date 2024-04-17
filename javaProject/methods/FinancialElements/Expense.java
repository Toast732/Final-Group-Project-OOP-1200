package javaProject.methods.FinancialElements;

public class Expense {
    int expenseAmount;
    float expenseFrequency;
    String expenseTitle;
    public Object ExpenseSource(String title, int amount, int payments, int time){
        this.expenseTitle = title;
        this.expenseAmount = amount;
        GetFrequency(payments, time);
        return(this.expenseTitle);
    }


    public void GetFrequency(int numPayments, int time){
        this.expenseFrequency = (float) numPayments / time;
    }
}
