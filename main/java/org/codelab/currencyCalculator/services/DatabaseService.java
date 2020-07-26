package org.codelab.currencyCalculator.services;

import org.codelab.currencyCalculator.model.CurrencyExchange;
import org.codelab.currencyCalculator.services.data.CurrencyDAO;
import org.codelab.currencyCalculator.services.data.SqlCurrencyDAO;

import java.sql.SQLException;
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
            List<CurrencyExchange> new_data = getCurrency("USD", Arrays.asList("USD", "GBP", "AUD", "JPY", "GBP", "CAD", "PEN", "MXN", "ZAR", "RUB", "EUR"));
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

//null pointer exception thrown, debug
    public static void main(String[] args) throws SQLException {
        CurrencyDAO dao = new SqlCurrencyDAO();
        DatabaseService db = new DatabaseService(dao);
        dao.connectToDatabase(dao.getConnection());
        db.getDataFromAPIFillDatabase();
    }
}