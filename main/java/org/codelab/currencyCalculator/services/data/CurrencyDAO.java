package org.codelab.currencyCalculator.services.data;

import java.math.BigDecimal;
import java.sql.SQLException;

//Currency Data Access Object
public interface CurrencyDAO {


    //void updateCurrency(CurrencyExchange with);
    void updateCurrency(String currencyId, BigDecimal value) throws SQLException;

    //BigDecimal getCurrency(String currencyId, String baseCurrency);
    BigDecimal getCurrency(String currencyId);
}
