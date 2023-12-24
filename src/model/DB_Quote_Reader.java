package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
        assert tableName.toLowerCase().contains("quote"): "Data table named like quote_table is not found!";

        System.out.println("Opened database successfully");

        connection.close();
        statement.close();
        rs.close();
    }

    @Override
    public ArrayList<String> getCategories(){
        ArrayList<String> categories = new ArrayList<String>();

        // get categories from the DB, do something with "categories"

        return categories;
    }

    @Override
    public QuoteEntity getQuote(String category){
        // TODO make this method, now it is just a stub
        return new QuoteEntity("sample text", "sample author", category);
    }

    @Override
    public QuoteEntity[] getNLines(int amount) throws Exception {
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
}
