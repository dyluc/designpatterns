package com.thenullproject.designpatterns.factory;

public class Bitcoin implements Cryptocurrency {

    @Override
    public String getTickerSymbol() {
        return "BTC";
    }
}
