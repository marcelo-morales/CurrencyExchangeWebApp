package org.codelab.currencyCalculator.services;

import org.codelab.currencyCalculator.model.CurrencyExchange;
import org.codelab.currencyCalculator.services.data.CurrencyDAO;

import java.util.List;

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




    public void getDataFromAPIFillDatabase() {
        String inputBy

    }



}
