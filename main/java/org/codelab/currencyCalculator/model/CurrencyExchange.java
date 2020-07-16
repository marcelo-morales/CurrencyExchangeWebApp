package org.codelab.currencyCalculator.model;

import java.math.BigDecimal;
import java.util.Date;

import com.google.common.base.Objects;

public class CurrencyExchange {

    private final String currencyId;
    private final BigDecimal exchangeRate;
    private final String baseCurrency;
    private final Date timestamp;

    public CurrencyExchange(String currencyId, BigDecimal exchangeRate, String baseCurrency, Date timestamp) {
        this.currencyId = currencyId;
        this.exchangeRate = exchangeRate;
        this.baseCurrency = baseCurrency;
        this.timestamp = timestamp;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "CurrencyExchange{" +
                "currencyId='" + currencyId + '\'' +
                ", exchangeRate=" + exchangeRate +
                ", baseCurrency='" + baseCurrency + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CurrencyExchange that = (CurrencyExchange) o;
        return Objects.equal(currencyId, that.currencyId) &&
                Objects.equal(exchangeRate, that.exchangeRate) &&
                Objects.equal(baseCurrency, that.baseCurrency) &&
                Objects.equal(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(currencyId, exchangeRate, baseCurrency, timestamp);
    }
}
