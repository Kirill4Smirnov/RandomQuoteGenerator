package model;

import java.sql.*;
import java.util.ArrayList;


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
        assert tableName.toLowerCase().contains("quote") : "Data table named like quote_table is not found!";

        System.out.println("Opened database successfully");

        connection.close();
        statement.close();
        rs.close();
    }

    @Override
    public ArrayList<String> getCategories() throws Exception {
        ArrayList<String> categories = new ArrayList<String>();

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT DISTINCT category FROM " + tableName + " ;");

        while (rs.next()) {
            categories.add(rs.getString("category"));
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
        ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName + " LIMIT " + Integer.toString(amount + 1) + ';');

        QuoteEntity[] resArr = new QuoteEntity[amount];
        int idx = 0;
        while (rs.next() && idx < amount) {
            resArr[idx] = new QuoteEntity(rs.getString("txt"), rs.getString("author"), rs.getString("category"));
            idx++;
        }


        connection.close();
        statement.close();
        rs.close();
        return resArr;
    }

    @Override
    public QuoteEntity[] getRandomQuotes(int num) throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName + " ORDER BY RANDOM() LIMIT " + Integer.toString(num + 1) + ';');

        QuoteEntity[] resArr = new QuoteEntity[num];
        int idx = 0;
        while (rs.next() && idx < num) {
            resArr[idx] = new QuoteEntity(rs.getString("txt"), rs.getString("author"), rs.getString("category"));
            idx++;
        }


        connection.close();
        statement.close();
        rs.close();
        return resArr;
    }

    @Override
    public QuoteEntity[] getRandomQuotes(String category, int num) throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName + " WHERE category='" + category + "' ORDER BY RANDOM() LIMIT " + Integer.toString(num + 1) + " ;");

        QuoteEntity[] resArr = new QuoteEntity[num];
        int idx = 0;
        while (rs.next() && idx < num) {
            resArr[idx] = new QuoteEntity(rs.getString("txt"), rs.getString("author"), rs.getString("category"));
            idx++;
        }


        connection.close();
        statement.close();
        rs.close();
        return resArr;
    }

    @Override
    public QuoteEntity[] getRandomQuotes(String author, String category, int num) throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName + " WHERE category='" + category + "' and author='" + author+ "' ORDER BY RANDOM() LIMIT " + Integer.toString(num + 1) + ';');

        QuoteEntity[] resArr = new QuoteEntity[num];
        int idx = 0;
        while (rs.next() && idx < num) {
            resArr[idx] = new QuoteEntity(rs.getString("txt"), rs.getString("author"), rs.getString("category"));
            idx++;
        }


        connection.close();
        statement.close();
        rs.close();
        return resArr;
    }
}
