package org.codelab.currencyCalculator.services;

import spark.Spark;

public class CurrencyService {

    //DB service
    private DatabaseService databaseService;

    //Data Provider
    private DataProvider dataProvider;

    //constructor
    public CurrencyService(DatabaseService databaseService, DataProvider dataProvider) {
        this.databaseService = databaseService;
        this.dataProvider = dataProvider;
    }

    //methods
    //may need to come up with a query, or question object
    //CurrencyConversion may need need more things

    //call the database service
    //will use currencyDAO to get the currency
    //will get me back CurrencyExchange object
    //want to get most recent one, sort by date, will get most recent CurrencyService
    //will return BigDecimal


    /*
    public BigDecimal getAmount(BigDecimal inputAmount, String currencyNameFrom, String currencyIdTo) {

        // databaseService to lookup the current info
        // this assumes USD from
        BigDecimal conversionRate = databaseService.convertFromTo(currencyIdTo);
        return inputAmount.multiply(conversionRate);
        //java.math.BigDecimal.multiply(BigDecimal multiplicand) is an inbuilt method in java that
        // returns a BigDecimal whose value is (this × multiplicand),

    }

    //will return JSON
    public CurrencyConversion doCurrencyConversion(String currencyFrom, String currencyTo, BigDecimal amountFrom) {
        //get("/");

        SqlCurrencyDAO accessObject = new SqlCurrencyDAO();
        Connection connection = accessObject.getConnection();
        accessObject.connectToDatabase(connection);
        DatabaseService databaseService = new DatabaseService(accessObject);


        //call the database to get the info ... or call the existing method in this class getAmount.

        //load the data into the CurrencyConversion object.

        //return that new CurrencyConversion.

        //call the database to get the info ... or call the existing method in this class getAmount.

        //load the data into the CurrencyConversion object.

        //return that new CurrencyConversion.
        return null;
    }






    public BigDecimal getAmount(BigDecimal inputAmount, String currencyId) {
        // dbservice to lookup the current info

        BigDecimal conversionRate = databaseService.convertFromTo(currencyId);
        return inputAmount.multiply(conversionRate);
    }

    public BigDecimal getCurrentRate(String currencyId) {
        BigDecimal rate = getRate(currencyId);
        return rate;
    }

    //return the dataService
    public DatabaseService getDatabaseService() {
        return databaseService;
    }

    //return the dataprovider
    public static DataProvider getDataProvider() {
        return dataProvider;
    }





    /*
    Spark Java will be API entry point, will be an HTTP call
    RPC type and Rest type
    RPC best thing, less complicated



//Sparkjava

        //API call to get currency
//     Http://host/convert?toCurrency=EUR&amount=234.45   (GET)
//verb tht we are using is convert
//will give it the to currency, in this case EUR
//will give it the amount
//when hit it, this access point, will call the CurrencyService
//CurrencyService will call DataBase Service, will get the stuff do the conversion, and then will present it back, will return  a JSON object
//JSON object will be a query object,


    Example JSON object that is returned, will be query object, query JSON
    this is your query, how query will look like if do it in JSON

    input will be a GET
    response object is JSON, like in DataProvider
    need to have a response object in model


      {
         "fromCurrency":"USD",
         "toCurrency":"EUR",
         "fromAmount":"1342.23",
         "toAmount: "2343.54"
      }

    */

    public static void main(String [] args) {
        System.out.println("Please work");
        Spark.get("/convert", (req, res) -> "This is a check! If got here, it worked");

        Spark.get("/hello/:name", (request, response) -> {
            return "Hello: " + request.params(":name");
        });


        // Using Route, error handling
        Spark.notFound((req, res) -> {
            res.type("application/json");
            return "{\"message\":\"Sorry for the error, please let us know how to fix this by contacting the owner(s) of this application\"}";
        });





        /*
        SqlCurrencyDAO myDataAccessObject = new SqlCurrencyDAO(myconnection);

        DatabaseService db = new DatabaseService(myDataAccessObject);

        CurrencyService cs = new CurrencyService(db, getDataProvider());

        db.getDataFromDatabase();
        */
    }
}
