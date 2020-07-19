package org.codelab.currencyCalculator.services.data;

import java.math.BigDecimal;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;

public class SqlCurrencyDAO implements CurrencyDAO {

    //database connection --> using JDBC.
    //set up connection with Postgres database
    private final String url = "jdbc:postgresql://localhost/currency_exchange";
    private final String user = "marcelomorales";
    private final String password = "leonardo11";
    private Connection connection = null;


    public SqlCurrencyDAO(Connection connection) {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException unableToConnect) {
            System.out.println(unableToConnect.getMessage());
            System.exit(0);
        }
        }
        //if got here, connected to the database

    }

    /*
     * will update a currency using SQL
     */
    @Override
    public void updateCurrency(String currencyId, BigDecimal value) throws SQLException {

        //use db connection to do the update
        try  {
            Statement update = this.connection.createStatement();
            ResultSet result_data = update.executeQuery("INSERT  INTO currencyexchange (currency_id, rate)" +
                    "VALUES (currencyId, value )");
            //checking to see if worked
            while(result_data.next()) {
                System.out.print("Updated currency Id is: "+result_data.getString("currency_id")+", ");
                System.out.print("Updated rate is: "+result_data.getFloat("rate")+", ");
                System.out.println();
            }
        }
        //updating the rate of the currency did not work, exception thrown and caught
        catch (SQLException statement) {
            System.out.println(statement.getMessage());
        }

    }

    /*
     * will get the rate of a currency using SQL
     */
    @Override
    public BigDecimal getRate(String currencyId) {
        //use db connection to get the currency, convert it to a BigDecimal and return it.
        try  {
            Statement return_currency = this.connection.createStatement();
            ResultSet result_data = return_currency.executeQuery("SELECT rate WHERE currency_id = 'currencyId' SORT BY timestamp");
            //checking to see if worked
            while(result_data.next()) {
                System.out.print("What is returned from this function is: "+result_data.getFloat("rate")+", ");
                System.out.println();
                BigDecimal return_rate = new BigDecimal(result_data.getFloat("rate"));
                return return_rate;
            }
        }
        //getting the rate of the currency did not work, exception thrown and caught
        catch (SQLException statement) {
            System.out.println(statement.getMessage());

        }
            //error happened, return null
            return null;
    }

    /*
    Will get the timestamp of a currency using SQL
     */
    public Timestamp getTimestamp(String currencyId) {
        //use db connection to get the currency, convert it to a BigDecimal and return it.
        try  {
            Statement return_currency = this.connection.createStatement();
            ResultSet result_data = return_currency.executeQuery("SELECT timestamp WHERE currency_id = 'currencyId'");
            //checking to see if worked
            while(result_data.next()) {
                System.out.print("What is returned from this function is: "+result_data+", ");
                System.out.println();
                Timestamp return_time = new Timestamp(result_data);
                return return_time;
            }
        }
        //getting the rate of the currency did not work, exception thrown and caught
        catch (SQLException statement) {
            System.out.println(statement.getMessage());

        }
        //error happened, return null
        return null;
    }


}
