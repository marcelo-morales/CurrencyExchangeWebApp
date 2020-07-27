package org.codelab.currencyCalculator.services;

import org.codelab.currencyCalculator.model.CurrencyExchange;
import spark.Spark;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import static org.codelab.currencyCalculator.services.DatabaseService.getAllInformation;

public class CurrencyService {

    //DB service
    private DatabaseService databaseService;

    //Data Provider
    private DataProvider dataProvider;

    public Map<String, BigDecimal> mapOfRates;

    //constructor
    public CurrencyService(DatabaseService databaseService, DataProvider dataProvider) {
        this.databaseService = databaseService;
        this.dataProvider = dataProvider;
    }

    public static void main(String [] args) throws Exception {
        System.out.println("Please work");
        Spark.get("/convert", (req, res) -> "This is a check! If got here, it worked");

        Spark.get("/hello/:name", (request, response) -> {
            //request.params("convert")
            return "Hello " + request.params(":name") + "! Welcome to the Currency Exchange Web Application!";
        });

        // Using Route, error handling
        Spark.notFound((req, res) -> {
            res.type("application/json");
            return "{\"message\":\"Sorry for the error, please let us know how to fix this by contacting the owner(s) of this application\"}";
        });


        List<CurrencyExchange> results = getAllInformation("USD", Arrays.asList("USD","GBP","AUD", "JPY", "GBP", "CAD", "PEN", "MXN", "ZAR", "RUB", "EUR"));
        ListIterator<CurrencyExchange> it = results.listIterator();
        int index = 0;
        while (it.hasNext()) {
            CurrencyExchange next = (CurrencyExchange)it.next();
            System.out.println(next.toString());
            BigDecimal rate = results.get(index).getExchangeRate();
            System.out.println("The corresponding rate is " + rate);
            ++index;
        }
    }

    public static Map<String, BigDecimal> updateAndReturnMapOfRates() throws Exception {
        List<CurrencyExchange> results = getAllInformation("USD", Arrays.asList("USD","GBP","AUD", "JPY", "GBP", "CAD", "PEN", "MXN", "ZAR", "RUB", "EUR"));
        ListIterator<CurrencyExchange> it = results.listIterator();
        int index = 0;
        while (it.hasNext()) {
            CurrencyExchange next = (CurrencyExchange)it.next();
            BigDecimal rate = results.get(index).getExchangeRate();
            String currency_id = results.get(index).getCurrencyId();
            ++index;

        }
    }

    public static BigDecimal doConversion(String currencyFrom, String currencyTo, BigDecimal inputAmount, BigDecimal rateForConversion) throws Exception {

        return inputAmount.multiply(rateForConversion);
    }



}
