package org.codelab.currencyCalculator.services;
import java.io.*;

import java.math.BigDecimal;

public class CurrencyService {

    //DB service
    private final DatabaseService databaseService;

    //Data Provider
    private final DataProvider dataProvider;

    //constructor
    public CurrencyService(DatabaseService databaseService, DataProvider dataProvider) {
        this.databaseService = databaseService;
        this.dataProvider = dataProvider;
    }


    //methods
    public BigDecimal getAmount(BigDecimal inputAmount, String currencyId) {
        // dbservice to lookup the current info

        BigDecimal conversionRate = databaseService.convertFromTo(currencyId);
        return inputAmount.multiply(conversionRate);
    }

    public BigDecimal getCurrentRate(String currencyId) {
        BigDecimal rate = getRate(currencyId);
        return rate;
    }

    public static DataProvider getDataProvider() {
        return this.dataProvider;
    }



    // calculate to do conversion
    // return results.

    //private calculate(currentFrom, currencyTo, amount)
    //use DB service to lookup current conversion
    //due calculation
    //return results


    public static void Main(String ... args) {
        //create
        // DatabaseService(CurrencyDAO)
        // CurrencyService(DatabaseService)

        DatabaseService db = new DatabaseService(currencyDAO currencyDAO);

        CurrencyService cs = new CurrencyService(db, getDataProvider());

        db.getDataFromDatabase();




        // load DB with Data from the DataProvider

        // Dummy data loader.

        // ------------- //

        // call the data provider and get the currency exchange rates for our 10
        // currencies. (EUR, CAD, GBP, YEN, YUAN, Ruble, Mexican Peso, AUD, Peru SOL) -> USD

        // currencyService.convert(value, currency);



        /* Spark java for next time  */

    }
}
