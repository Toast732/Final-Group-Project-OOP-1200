package javaProject.stocks;

public class Stock {
    public int numberOfStock;
    public float stockPrice;
    public String transactionType;

    public String stockName;

    public Stock(int stockNumber, float price, String type, String name){
        this.numberOfStock = stockNumber;
        this.stockPrice = price;
        this.transactionType = type;
        this.stockName = name;
    }
}

