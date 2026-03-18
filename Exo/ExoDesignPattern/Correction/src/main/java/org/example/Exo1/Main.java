package org.example.Exo1;

public class Main {

    public static void main(String[] args) {
        CurrencyConverter currencyConverter = new CurrencyConverter();
        CurrencyAdapter currencyAdapter = new CurrencyConverterAdapter(currencyConverter);

        System.out.println("100 EUR en USD "+ currencyAdapter.convert("EUR","USD",100) );
        System.out.println("80 USD en GBP "+ currencyAdapter.convert("USD","GBP",80) );
    }
}
