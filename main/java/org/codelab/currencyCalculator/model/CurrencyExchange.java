package org.codelab.currencyCalculator.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import com.google.common.base.Objects;

public class CurrencyExchange {

    //we should always be working with this
    private final String currencyId; //ID of each currency
    private final BigDecimal exchangeRate; //exchange rate of each currency, initially will be rate to convert from inputCurrency to the dollar
    private final String baseCurrency; //initially will always be dollar
    private final Date timestamp; //time that calculation happened, when called database

    //constructor
    public CurrencyExchange(String currencyId, BigDecimal exchangeRate, String baseCurrency, Date timestamp) {
        this.currencyId = currencyId;
        this.exchangeRate = exchangeRate;
        this.baseCurrency = baseCurrency;
        this.timestamp = timestamp;
    }

    public String getCurrencyId() {
        return this.currencyId;
    }

    public BigDecimal getExchangeRate() {
        return this.exchangeRate;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public Date getTimestamp() {
        return this.timestamp;
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

        //object o, object passed in, does exist, will now compare each field of the object
        CurrencyExchange that = (CurrencyExchange) o;
        return Objects.equal(currencyId, that.currencyId) &&
                Objects.equal(exchangeRate, that.exchangeRate) &&
                Objects.equal(baseCurrency, that.baseCurrency) &&
                Objects.equal(timestamp, that.timestamp);
    }

    @Override
    //A hash code is an integer value that is associated with each object in Java.
    public int hashCode() {
        return Objects.hashCode(currencyId, exchangeRate, baseCurrency, timestamp);
    }
}
