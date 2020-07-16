package org.codelab.currencyCalculator.model;

import java.math.BigDecimal;

public class RawRate {

    private final String currencyId;
    private final BigDecimal rate;


    public RawRate(String currencyId, BigDecimal rate) {
        this.currencyId = currencyId;
        this.rate = rate;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
