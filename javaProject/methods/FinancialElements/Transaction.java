package javaProject.methods.FinancialElements;

import java.util.ArrayList;

public class Transaction {
    private int purchasePrice;
    private int newAccountTotal;

    public int transactionBuy(int price, int accountTotal){
        this.purchasePrice = price;
        this.newAccountTotal = accountTotal - price;
        return(-price);
    }
    public int transactionEarn(int price, int accountTotal){
        this.purchasePrice = price;
        this.newAccountTotal = accountTotal + price;
        return(price);
    }

    public int getAccountTotal(){
        return(this.newAccountTotal);
    }
}
