package com.thenullproject.designpatterns.factory;

public class Ethereum implements Cryptocurrency {

    @Override
    public String getTickerSymbol() {
        return "ETH";
    }
}
