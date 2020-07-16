package org.codelab.currencyCalculator.services.data;

import java.math.BigDecimal;

//Currency Data Access Object
public interface CurrencyDAO {


    //void updateCurrency(CurrencyExchange with);
    void updateCurrency(String currencyId, BigDecimal value);

    //BigDecimal getCurrency(String currencyId, String baseCurrency);
    BigDecimal getCurrency(String currencyId);
}
