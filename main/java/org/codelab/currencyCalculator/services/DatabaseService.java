package org.codelab.currencyCalculator.services;

import org.codelab.currencyCalculator.model.CurrencyExchange;
import org.codelab.currencyCalculator.services.data.CurrencyDAO;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static org.codelab.currencyCalculator.services.OpenExchangeRatesDataProvider.getCurrency;


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
            List <CurrencyExchange> new_data =  getCurrency("USD", Arrays.asList("USD","GBP","AUD"));
            ListIterator<CurrencyExchange> it = new_data.listIterator();
            CurrencyDAO currencyDAO = getCurrencyDAO();

            while (it.hasNext()) {
                CurrencyExchange next = (CurrencyExchange)it.next();
                currencyDAO.updateCurrency(next.getCurrencyId(), next.getExchangeRate());
                System.out.println(next.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}
