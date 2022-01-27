package com.thenullproject.designpatterns.factory;

public class CryptocurrencyFactory {

    public static Cryptocurrency createCurrency(String type) {

        return switch(type) {
            case "Bitcoin" -> new Bitcoin();
            case "Ethereum" -> new Ethereum();
            case "Cardano" -> new Cardano();
            case "Dogecoin" -> new Dogecoin();
            default -> throw new IllegalArgumentException("Illegal Crypto");
        };

    }
}
