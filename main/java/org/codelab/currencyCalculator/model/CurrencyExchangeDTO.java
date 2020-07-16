package org.codelab.currencyCalculator.model;

import java.math.BigDecimal;
import java.util.Map;
/*
Database Transfer Object
 */
public class CurrencyExchangeDTO {

    private final String timestamp;
    private final String inputCurrency;
    private final Map<String, BigDecimal> rates;

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
}
