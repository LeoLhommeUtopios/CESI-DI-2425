package org.example.Exo1;

public class CurrencyConverter {

    public double convertToUSD(String currency, double amount){
        return switch (currency){
            case "EUR" -> amount *1.1;
            case "GBP" -> amount*1.3;
            default -> amount;
        };
    }
    public double convertFromUSD(String currency, double amount){
        return switch (currency){
            case "EUR" -> amount /1.1;
            case "GBP" -> amount/1.3;
            default -> amount;
        };
    }

}
