package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.EmptyStackException;


public class DB_Quote_Reader extends QuoteReader {

    private final String tableName;
    private final String url;

    public DB_Quote_Reader(String filePath) throws Exception {
        super(filePath);
        url = "jdbc:sqlite:" + filePath;

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT name FROM sqlite_schema \n" +
                "WHERE type IN ('table','view') \n" +
                "AND name NOT LIKE 'sqlite_%'\n" +
                "ORDER BY 1;");

        tableName = rs.getString("name");
        assert tableName.toLowerCase().contains("quote"): "Data table named like quote_table is not found!";

        System.out.println("Opened database successfully");

        connection.close();
        statement.close();
        rs.close();
    }

    @Override
    public ArrayList<String> getCategories() throws Exception{
        ArrayList<String> categories = new ArrayList<String>();

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery( "SELECT DISTINCT category FROM " + tableName + " ;");

        int idx = 0;
        while (rs.next()){
            categories.set(idx, rs.getString("category"));
            idx++;
        }


        connection.close();
        statement.close();
        rs.close();

        return categories;
    }


    @Override
    public QuoteEntity[] getFirstLines(int amount) throws Exception {
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery( "SELECT * FROM " + tableName + " LIMIT " + Integer.toString(amount+1) + ';');

        QuoteEntity[] resArr = new QuoteEntity[amount];
        int idx = 0;
        while (rs.next() && idx < amount){
            resArr[idx] = new QuoteEntity(rs.getString("txt"), rs.getString("author"), rs.getString("category"));
            idx++;
        }


        connection.close();
        statement.close();
        rs.close();
        return resArr;
    }

    @Override
    public QuoteEntity QuoteGetRandomQuotes(int num) {
        return null;
    }

    @Override
    public QuoteEntity QuoteGetRandomQuotes(String category, int num) {
        return null;
    }

    @Override
    public QuoteEntity QuoteGetRandomQuotes(String author, String category, int num) {
        return null;
    }
}
