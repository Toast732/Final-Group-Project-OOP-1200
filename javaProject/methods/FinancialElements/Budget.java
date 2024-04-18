package javaProject.methods.FinancialElements;

public class Budget extends ManageFinances {
    private String budgetTitle;
    private float budgetAmount;
    private int budgetTime;
    public void generateBudget(String budgetName, float allotment, int timeFrame) {
        this.budgetTitle = budgetName;
        float totalAmount = accountBalance;
        if (totalAmount > allotment){
            System.out.println("requested budget allotment exceeds total available funds.");
        }
        else{
            this.budgetAmount = allotment;
            this.budgetTime = timeFrame;
        }

    }
}
