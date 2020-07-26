package org.codelab.currencyCalculator.services.data;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

//Currency Data Access Object
public interface CurrencyDAO {

    void updateCurrency(String new_currencyId, BigDecimal new_value, Timestamp new_date) throws SQLException;

    //BigDecimal getCurrency(String currencyId, String baseCurrency);
    BigDecimal getRate(String currencyId);

    Timestamp getTimestamp(String currencyId);

    public void connectToDatabase(Connection connection);

    public Connection getConnection() throws SQLException;

}
