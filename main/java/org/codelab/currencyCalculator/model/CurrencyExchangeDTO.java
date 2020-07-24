package org.codelab.currencyCalculator.model;

import java.math.BigDecimal;
import java.util.Map;
/*
Currency Exchange Database Transfer Object
 */
public class CurrencyExchangeDTO {

    private final String timestamp;
    private final String inputCurrency;
    private final Map<String, BigDecimal> rates; //An object that maps keys to values. A map cannot contain duplicate keys; each key can map to at most one value.

    public CurrencyExchangeDTO(String timestamp, String inputCurrency, Map<String,BigDecimal> rates) {
        this.timestamp = timestamp;
        this.inputCurrency = inputCurrency;
        this.rates = rates;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getInputCurrency() {
        return this.inputCurrency;
    }

    public Map<String,BigDecimal> getRates() {
        return this.rates;
    }

    public String getBase() {
        return "Hello";
    }
}
