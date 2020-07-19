package org.codelab.currencyCalculator.model;
import java.math.BigDecimal;
import com.google.gson.Gson;


public class CurrencyConversion {
    private final String fromCurrency;
    private final String toCurrency;
    private final BigDecimal fromAmount;
    private final BigDecimal toAmount;

    //constructor for CurrencyConversion
    public CurrencyConversion(String fromCurrency, String toCurrency, BigDecimal fromAmount, BigDecimal toAmount) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
    }

    //convert CurrencyConversion object to JSON
    public String convertToJson() {
        return new Gson().toJson(CurrencyConversion.class);
    }
}
