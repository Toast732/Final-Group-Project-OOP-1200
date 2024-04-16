package javaProject.methods;

public class Transaction {
    private int purchasePrice;
    private int newAccountTotal;

    public int transaction(int price, int accountTotal){
        this.purchasePrice = price;
        this.newAccountTotal = accountTotal - price;
        return(-price);
    }
}
