//htt=://host/convert?toCurrency=EUR&amount=234.55

//JSO N would be a post





package org.codelab.currencyCalculator.services;

import org.codelab.currencyCalculator.model.CurrencyExchange;
import org.codelab.currencyCalculator.services.data.CurrencyDAO;
import org.codelab.currencyCalculator.services.data.SqlCurrencyDAO;
import spark.Spark;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
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

        while (index < results.size()) {
            CurrencyExchange current = results.get(index);
            BigDecimal rate = current.getExchangeRate();
            String id = current.getCurrencyId();
            this.mapOfRates.put(id, rate);
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

    //Will use this
    //http://host/convert/toCurrency/EUR/200/

    //Chris wants
    //http://host/convert?toCurrency=EUR&amount=234.45




    public static void main(String[] args) throws Exception {
        System.out.println("Please work");

        Spark.get("/convert/*/to/*", (request, response) -> {
            String path = request.matchedPath();
            String [] parameters = path.split("/");
            for (int i = 0; i < parameters.length; ++i) {
                String current = parameters[i];

                System.out.println("Parameters I need are " + parameters[i]);
            }


            System.out.println("This is URL path " + path);

            String fromCurrency = "USD";
            String toCurrency = "EUR";
            BigDecimal fromAmount = BigDecimal.valueOf(234.50);
            //BigDecimal toAmount = doConversion(fromCurrency, toCurrency, fromAmount);
            CurrencyConversion currency_to_convert = new CurrencyConversion(fromCurrency, toCurrency, fromAmount, toAmount);


            return "Number of splat parameters: " + request.splat().length;
        });

        /*
        Spark.path("/convert", () -> {
                    //Spark.before("/*", (q, a) -> log.info("Received api call"));
                    Spark.get("?toCurrency", (request, response) -> {
                        return "Working so far";

                        //Spark.post("/add", EmailApi.addEmail);
                        //Spark.put("/change", EmailApi.changeEmail);
                        //Spark.delete("/remove", EmailApi.deleteEmail);
                    });

                });
        */




        //Spark.get("/convert", (req, res) -> "This is a check! If got here, it worked");

        Spark.get("/hello/:name", (request, response) -> {
            //request.params("convert")
            //create an object map
            //accept name
            //acept currency
            //make a Map
            //param.getname
            //will get an URL
            //Wednesday we have to show

            return "Hello " + request.params(":name") + "! Welcome to the Currency Exchange Web Application!";
        });

        // Using Route, error handling
        Spark.notFound((req, res) -> {
            res.type("application/json");
            return "{\"message\":\"Sorry for the error, please let us know how to fix this by contacting the owner(s) of this application\"}";
        });

        // matches "GET /say/hello/to/world"
// request.splat()[0] is 'hello' and request.splat()[1] 'world'
        Spark.get("/say/*/to/*", (request, response) -> {
            String path = request.matchedPath();
            System.out.println("These are the parameters that the user will GET in url " + path);
            return "Number of splat parameters: " + request.splat().length + " And also " + request.matchedPath();
        });




        BigDecimal answer_of_conversion = BigDecimal.valueOf(0);
        String sample_input_currency_Id = "USD";
        String sample_output_currency_Id = "EUR";

        BigDecimal sample_amount_to_convert = BigDecimal.valueOf(234.45);


        try {


            //sample_amount_to_convert = BigDecimal.valueOf(234.45);


            CurrencyDAO cDao = new SqlCurrencyDAO();
            DatabaseService ds = new DatabaseService(cDao);
            DataProvider dp = new OpenExchangeRatesDataProvider();
            Map<String, BigDecimal> mapOfRates = new HashMap<>();

            CurrencyService cs = new CurrencyService(ds, dp, mapOfRates);

            Map<String, BigDecimal> list_of_all_rates = cs.getAndReturnRates();

            answer_of_conversion = cs.doConversion(sample_input_currency_Id, sample_output_currency_Id, sample_amount_to_convert);
            answer_of_conversion = answer_of_conversion.setScale(2, RoundingMode.CEILING);
            System.out.println("Your converted amount is " + answer_of_conversion);

            //create JSON object as instructed
            //Spark java with format, /convert, correspond to parameters
        }
        catch (NullPointerException error) {
            System.out.println("Something wrong with user input. Please make sure to choose one of the provided currency choices");
        }

        JsonObjectBuilder json = Json.createObjectBuilder()
                .add("fromCurrency", "USD")
                .add("toCurrency", "EUR")
                .add("fromAmount", BigDecimal.valueOf(3))
                .add("toAmount", answer_of_conversion);
        String result = json.toString();

        System.out.println("This is the result in JSON " + result.toString());
        /*
        JsonReader jsonReader = Json.createReader(new StringReader("{\"fromCurrency\:sample_input_currency_Id\"\",\"age\":3,\"bitable\":false}"));
        JsonObject jobj = jsonReader.readObject();
        System.out.println(jobj);
        */
    }

}
