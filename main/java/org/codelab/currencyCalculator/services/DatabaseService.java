package org.codelab.currencyCalculator.services;

import java.math.BigDecimal;

import org.codelab.currencyCalculator.services.data.CurrencyDAO;

/*
 *  This is the DataBase Service class
 */
public class DatabaseService {

    private final CurrencyDAO currencyDAO; //currency data access object

    public DatabaseService(CurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
    }

    public CurrencyDAO getCurrencyDAO() {
        return currencyDAO;
    }

    /*
    public BigDecimal convertFromTo(String currencyTo) {
        //its doing Too much.
        return currencyDAO.getCurrency(currencyTo);
    }

     */

}
