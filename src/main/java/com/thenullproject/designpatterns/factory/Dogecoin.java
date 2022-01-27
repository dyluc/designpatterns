package com.thenullproject.designpatterns.factory;

public class Dogecoin implements Cryptocurrency{

    @Override
    public String getTickerSymbol() {
        return "DOGE";
    }
}
