package org.example.ExoAdapter;

public class CurrencyConverterAdapter implements CurrencyAdapter{
    private CurrencyConverter currencyConverter;

    public CurrencyConverterAdapter(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    @Override
    public double convert(String fromCurrency, String toCurrency, double amount) {
        if(fromCurrency.equals("USD")){
            return currencyConverter.convertFromUSD(toCurrency,amount);
        }else {
            return currencyConverter.convertToUSD(fromCurrency,amount);
        }
    }
}
