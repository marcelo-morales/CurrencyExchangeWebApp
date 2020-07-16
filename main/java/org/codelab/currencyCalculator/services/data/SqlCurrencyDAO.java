package org.codelab.currencyCalculator.services.data;

import java.math.BigDecimal;
import java.sql.Connection;

public class SqlCurrencyDAO implements CurrencyDAO {

    //database connection --> using JDBC.
    //set up connection with Postgres database
    public SqlCurrencyDAO(Connection connection) {
        //do something with it.
    }

    /*
     * INSERT currencyRates cr SET cr.currencyName='someCurrency', cr.rate='12332', cr.timestamp='date/time' WHERE currencyName = ?
     */
    @Override
    public void updateCurrency(String currencyId, BigDecimal value) {

        //use db connection to do the update
    }

    /*
     * SELECT rate FROM CurrencyRates WHERE currencyName = "?" SORT BY timestamp
     */
    @Override
    public BigDecimal getCurrency(String currencyId) {
        //use db connection to get the currency, convert it to a BigDecimal and return it.
        return null;
    }
}
