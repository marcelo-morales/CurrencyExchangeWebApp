package org.codelab.currencyCalculator.services.data;

import java.math.BigDecimal;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;

public class SqlCurrencyDAO implements CurrencyDAO {

    //database connection --> using JDBC.
    //set up connection with Postgres database
    private final String url = "jdbc:postgresql:currency_exchange";
    private final String user = "marcelomorales";
    private final String password = "leonardo11";
    private Connection connection = null;

    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        }
        catch (SQLException unableToGetConnection) {
            System.out.println(unableToGetConnection.getMessage());
            System.exit(0);
        }
        return null;
    }

    public void connectToDatabase(Connection connection) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("I connected to the database!!!!!");
        } catch (SQLException unableToConnect) {
            System.out.println(unableToConnect.getMessage());
            System.exit(0);
        }
    }


    /*
     * will update a currency using SQL, will update the rate, id, and timestamp of a certain row in database
     * may have to use Prepared State,ent
     */
    @Override
    public void updateCurrency(String new_currencyId, BigDecimal new_value, Timestamp new_time) throws SQLException {
        //use db connection to do the update
        Connection c = this.getConnection();
        this.connectToDatabase(c);

        //String new_currencyId_again = "hello";

        //MongoDB

        //FireBase

        try {
            Statement update = c.createStatement();
            System.out.println("Did not work :( first time");

            ResultSet result_data = update.executeQuery( "INSERT  INTO currency_exchange (currency_id) " +
              "VALUES ('hello', new_value, new_time )");
            //checking to see if worked
            while (result_data.next()) {
                System.out.print("Updated currency Id is: " + result_data.getString("currency_id") + ", ");
                System.out.print("Updated rate is: " + result_data.getFloat("rate") + ", ");
                System.out.println();
            }
        }
        //updating the rate of the currency did not work, exception thrown and caught
        catch (NullPointerException statement) {
            System.out.println("Did not work :(, BADDDD");
            System.out.println(statement.getMessage());
        }

    }

    /*
     * will get the rate of a currency using SQL
     */
    @Override
    public BigDecimal getRate(String currencyId) {
        //use db connection to get the currency, convert it to a BigDecimal and return it.
        try {
            Statement return_currency = this.connection.createStatement();
            ResultSet result_data = return_currency.executeQuery("SELECT rate WHERE currency_id = 'currencyId' SORT BY date_of_calculation");
            //checking to see if worked
            while (result_data.next()) {
                System.out.print("What is returned from this function is: " + result_data.getFloat("rate") + ", ");
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
        try {
            Statement return_connection = this.connection.createStatement();
            ResultSet result_data = return_connection.executeQuery("SELECT date_of_calculation WHERE currency_id = 'currencyId'");
            //checking to see if worked
            while (result_data.next()) {
                System.out.print("What is returned from this function is: " + result_data.toString());
                System.out.println();
                //Timestamp return_time = new Timestamp();
                return null;
            }
        }
        //getting the rate of the currency did not work, exception thrown and caught
        catch (SQLException statement) {
            System.out.println(statement.getMessage());

        }
        //error happened, return null
        return null;
    }

        //check why there is a null pointer exception
    public static void main(String[] args) throws SQLException {
        SqlCurrencyDAO dao = new SqlCurrencyDAO();
        Connection con = dao.getConnection();
        dao.connectToDatabase(con);

        Timestamp t = new Timestamp(2020, 7, 11, 6, 4, 3 ,2 );
        dao.updateCurrency("1", BigDecimal.valueOf(3), t);

    }

}


