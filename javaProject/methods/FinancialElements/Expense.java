package javaProject.methods.FinancialElements;

public class Expense {
    float expenseAmount;
    float expenseFrequency;
    String expenseTitle;
    public Object ExpenseSource(String title, float amount, int payments, int time){
        this.expenseTitle = title;
        this.expenseAmount = amount;
        GetFrequency(payments, time);
        return(this.expenseTitle);
    }


    public void GetFrequency(int numPayments, int time){
        this.expenseFrequency = (float) numPayments / time;
    }
}
