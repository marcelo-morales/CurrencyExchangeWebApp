package org.codelab.currencyCalculator.services;

import org.codelab.currencyCalculator.model.CurrencyExchange;
import org.codelab.currencyCalculator.services.data.CurrencyDAO;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static org.codelab.currencyCalculator.services.OpenExchangeRatesDataProvider.getCurrencyFromAPI;


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

        try {
            List<CurrencyExchange> new_data = getAllInformation("USD", Arrays.asList("USD", "GBP", "AUD", "JPY", "GBP", "CAD", "PEN", "MXN", "ZAR", "RUB", "EUR"));
            ListIterator<CurrencyExchange> it = new_data.listIterator();
            CurrencyDAO currencyDAO = getCurrencyDAO();

            while (it.hasNext()) {
                System.out.println("Working");
                CurrencyExchange next = (CurrencyExchange) it.next();
                System.out.println("Working 2");

                currencyDAO.updateCurrency(next.getCurrencyId(), next.getExchangeRate(), next.getTimestamp());
                System.out.println("Working 3");
                System.out.println(next.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<CurrencyExchange> getAllInformation(String baseCurrency, List<String> targetCurrencies) throws Exception {
        List<CurrencyExchange> results = getCurrencyFromAPI("USD", Arrays.asList("USD","GBP","AUD", "JPY", "GBP", "CAD", "PEN", "MXN", "ZAR", "RUB", "EUR"));
        return results;
    }


//null pointer exception thrown, debug
    public static void main(String[] args) throws Exception {
        List<CurrencyExchange> results = getAllInformation("USD", Arrays.asList("USD","GBP","AUD", "JPY", "GBP", "CAD", "PEN", "MXN", "ZAR", "RUB", "EUR"));
        ListIterator<CurrencyExchange> it = results.listIterator();
        while (it.hasNext()) {
            CurrencyExchange next = (CurrencyExchange)it.next();
            System.out.println(next.toString());
        }



        //System.out.println("This is the response!!!! : " + results);

        /*
        CurrencyDAO dao = new SqlCurrencyDAO();
        DatabaseService db = new DatabaseService(dao);
        dao.connectToDatabase(dao.getConnection());
        db.getDataFromAPIFillDatabase();

         */
    }
}