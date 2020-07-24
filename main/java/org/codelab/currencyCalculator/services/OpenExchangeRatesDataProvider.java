package org.codelab.currencyCalculator.services;

import org.apache.http.client.utils.URIBuilder;
import org.codelab.currencyCalculator.model.CurrencyExchange;
import org.codelab.currencyCalculator.utils.CurrencyExchangeUtil;

import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

//An ordered collection (also known as a sequence). The user of this interface has precise control over where in the
// list each element is inserted. The user can access elements by their integer index (position in the list), and
// search for elements in the list.

public class OpenExchangeRatesDataProvider implements DataProvider {

    private static String APP_ID = "ef0fa92c95d345cd8b236c17f7da8cc8";
    private static String OPEN_EXCHANGE_URI = "openexchangerates.org";

    public static void main(String ... args) throws Exception {
        List<CurrencyExchange> results = getCurrency("EUR", Arrays.asList("USD","GBP","AUD"));
        System.out.println("This is the response: " + results);
    }

    private static List<CurrencyExchange> getCurrency(String baseCurrency, List<String> targetCurrencies ) throws Exception {

        URIBuilder uriBuilder = new URIBuilder();
        //Utility class for building URIs from their components
        //A Uniform Resource Identifier (URI) is a string of characters that unambiguously identifies a particular resource.


        uriBuilder.setScheme("https");
        uriBuilder.setHost(OPEN_EXCHANGE_URI);
        uriBuilder.setPath("/api/latest.json");
        uriBuilder.addParameter("app_id", APP_ID);
        uriBuilder.addParameter("base", "EUR");
        uriBuilder.addParameter("symbols", String.join(",", targetCurrencies));
        URL toQuery = uriBuilder.build().toURL();


        HttpRequest request = HttpRequest.newBuilder()
                .uri(toQuery.toURI())
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return CurrencyExchangeUtil.fromJson(response.body());

    }

    @Override
    /*
    this will get the actual data from the database, will load DB with Data from the DataProvider
    get the data from the database?, ignore...
     */
    public void getDataFromDatabase() {
        //pseudocode

    }
}
