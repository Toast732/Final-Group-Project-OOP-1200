package javaProject.methods;

import java.util.ArrayList;

public class Transaction {
    private int purchasePrice;
    private int newAccountTotal;
    private ArrayList<Integer> transactionList;

    public int transactionBuy(int price, int accountTotal){
        this.purchasePrice = price;
        this.newAccountTotal = accountTotal - price;
        this.transactionList.add(-price);
        return(-price);
    }
    public int transactionEarn(int price, int accountTotal){
        this.purchasePrice = price;
        this.newAccountTotal = accountTotal + price;
        this.transactionList.add(price);
        return(price);
    }

    public int getAccountTotal(){
        return(this.newAccountTotal);
    }
}
