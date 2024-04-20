package javaProject.transactions;

public class RegularTransaction extends Transaction {
    protected double dailyAmount;

    // Normal, gives daily amount.
    public RegularTransaction(String transactionName) {
        this.transactionName = transactionName;
    }

    private void setDailyAmount(double dailyAmount) {
        this.dailyAmount = dailyAmount;

        if (this.dailyAmount >= 0) {
            this.transactionType = "Income";
        } else {
            this.transactionType = "Expense";
        }
    }

    public void setYearly(double yearlyAmount) {
        this.setDailyAmount(yearlyAmount / 365);
    }

    public void setHourly(double hoursWorkedAWeek, double hourlyRate) {
        this.setDailyAmount(hourlyRate * hoursWorkedAWeek / 7);
    }

    public void setDaily(double dailyAmount){
        this.setDailyAmount(dailyAmount);
    }

    @Override
    public double getAmount(int days) {
        return this.dailyAmount * days;
    }
}
