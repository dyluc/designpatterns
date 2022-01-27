package com.thenullproject.designpatterns.factory;

public class Cardano implements Cryptocurrency {

    @Override
    public String getTickerSymbol() {
        return "ADA";
    }
}
