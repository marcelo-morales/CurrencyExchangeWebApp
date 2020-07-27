package org.codelab.currencyCalculator.services;

import org.codelab.currencyCalculator.model.CurrencyExchange;
import org.codelab.currencyCalculator.services.data.CurrencyDAO;
import org.codelab.currencyCalculator.services.data.SqlCurrencyDAO;
import spark.Spark;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.codelab.currencyCalculator.services.DatabaseService.getAllInformation;

public class CurrencyService {

    //DB service
    private final DatabaseService databaseService;

    //Data Provider
    private final DataProvider dataProvider;

    public Map<String, BigDecimal> mapOfRates;

    //constructor
    public CurrencyService(DatabaseService databaseService, DataProvider dataProvider, Map<String, BigDecimal> mapOfRates) {
        this.databaseService = databaseService;
        this.dataProvider = dataProvider;
        this.mapOfRates = mapOfRates;
    }

    public Map<String, BigDecimal> getAndReturnRates() throws Exception {
        List<CurrencyExchange> results = getAllInformation("USD", Arrays.asList("USD", "GBP", "AUD", "JPY", "GBP", "CAD", "PEN", "MXN", "ZAR", "RUB", "EUR"));
        //ListIterator<CurrencyExchange> it = results.listIterator();
        int index = 0;
        System.out.println("This is the rates " + results.toString());
        System.out.println(results.size());

        while (index < results.size()) {
            System.out.println("Marcelo");
            CurrencyExchange current = results.get(index);
            System.out.println("Marcelo 2");
            BigDecimal rate = current.getExchangeRate();
            String id = current.getCurrencyId();
            System.out.println("Marcelo 3");
            this.mapOfRates.put(id, rate);
            System.out.println("Marcelo 4");
            System.out.println("This is the result" + this.mapOfRates.toString());
            ++index;

            /*
            //..CurrencyExchange next = (CurrencyExchange) it.next();
            //System.out.println(next.toString());
            BigDecimal rate = results.get(index).getExchangeRate();
            String id = results.get(index).getCurrencyId();
            System.out.println("Rate is " + rate + " id is " + id);


            System.out.println("The corresponding rate is " + rate);
            this.mapOfRates.put(id, rate);
            System.out.println("HIIIIII");
            System.out.println(this.mapOfRates.toString());
            ++index;
            */

        }
        return this.mapOfRates;
    }


    public BigDecimal doConversion(String currencyFrom, String currencyTo, BigDecimal inputAmount) throws Exception {
        BigDecimal rateForConversion = this.mapOfRates.get(currencyTo);
        return inputAmount.multiply(rateForConversion);
    }

    public static void main(String[] args) throws Exception {
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

        try {
            String sample_input_currency_Id = "USD";
            String sample_output_currency_Id = "EUR";
            BigDecimal sample_amount_to_convert = BigDecimal.valueOf(234.45);


            CurrencyDAO cDao = new SqlCurrencyDAO();
            DatabaseService ds = new DatabaseService(cDao);
            DataProvider dp = new OpenExchangeRatesDataProvider();
            Map<String, BigDecimal> mapOfRates = new HashMap<>();

            CurrencyService cs = new CurrencyService(ds, dp, mapOfRates);

            Map<String, BigDecimal> list_of_all_rates = cs.getAndReturnRates();
            System.out.println("The list of all rates is " + list_of_all_rates.toString());


            BigDecimal answer_of_conversion = cs.doConversion(sample_input_currency_Id, sample_output_currency_Id, sample_amount_to_convert);
            answer_of_conversion = answer_of_conversion.setScale(2, RoundingMode.CEILING);
            System.out.println("Final answer is " + answer_of_conversion);

            //create JSON object as instructed
            //Spark java with format, /convert, correspond to parameters
        }
        catch (NullPointerException error) {
            System.out.println("Something wrong with user input. Please make sure to choose one of the provided currency choices");
        }
    }

}
