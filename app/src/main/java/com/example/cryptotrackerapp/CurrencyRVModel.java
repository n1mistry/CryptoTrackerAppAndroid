package com.example.cryptotrackerapp;

public class CurrencyRVModel {
    private int id;
    private String name;
    private String symbol;
    private double price;
    private String totalSupply;
    private String circulatingSupply;
    private String maxSupply;


    public CurrencyRVModel(int id, String name, String symbol, double price, String totalSupply, String circulatingSupply, String maxSupply) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.totalSupply = totalSupply;
        this.circulatingSupply = circulatingSupply;
        this.maxSupply = maxSupply;
    }

    public int getId() {return id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(String circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    public String getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(String maxSupply) {
        this.maxSupply = maxSupply;
    }
}

