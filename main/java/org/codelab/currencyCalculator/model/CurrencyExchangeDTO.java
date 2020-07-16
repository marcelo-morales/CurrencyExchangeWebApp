package org.codelab.currencyCalculator.model;

import java.math.BigDecimal;
import java.util.Map;

public class CurrencyExchangeDTO {

    private final String timestamp;
    private final String base;
    private final Map<String, BigDecimal> rates;

    public CurrencyExchangeDTO(String timestamp, String baseCurrency, Map<String,BigDecimal> rates) {
        this.timestamp = timestamp;
        this.base = baseCurrency;
        this.rates = rates;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getBase() {
        return base;
    }

    public Map<String,BigDecimal> getRates() {
        return rates;
    }
}
