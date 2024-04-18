package javaProject.methods.FinancialElements;

import java.util.ArrayList;

public class Transaction {
    private float purchasePrice;
    private float newAccountTotal;

    public float transactionBuy(float price, float accountTotal){
        this.purchasePrice = price;
        this.newAccountTotal = accountTotal - price;
        return(-price);
    }
    public float transactionEarn(float price, float accountTotal){
        this.purchasePrice = price;
        this.newAccountTotal = accountTotal + price;
        return(price);
    }

    public float getAccountTotal(){
        return(this.newAccountTotal);
    }
}
