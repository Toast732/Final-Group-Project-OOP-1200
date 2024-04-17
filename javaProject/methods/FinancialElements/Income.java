package javaProject.methods.FinancialElements;

public class Income {
    int incomeAmount;
    float incomeFrequency;
    String incomeTitle;

    public Object ExpenseSource(String title, int amount, int payments, int time){
        this.incomeTitle = title;
        this.incomeAmount = amount;
        GetFrequency(payments, time);
        return(this.incomeTitle);
    }


    public void GetFrequency(int numPayments, int time){
        this.incomeFrequency = (float) numPayments / time;
    }
}
