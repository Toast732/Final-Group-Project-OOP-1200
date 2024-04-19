package javaProject.stocks;

public class Stock {
    public int numberOfStock;
    public float stockPrice;
    public String transactionType;

    public Stock(int stockNumber, float price, String type){
        this.numberOfStock = stockNumber;
        this.stockPrice = price;
        this.transactionType = type;
    }
}

