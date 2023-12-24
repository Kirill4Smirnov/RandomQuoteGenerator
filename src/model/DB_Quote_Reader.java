package model;

import java.sql.Connection;
import java.util.ArrayList;

public class DB_Quote_Reader extends QuoteReader {
    public DB_Quote_Reader(String filePath) throws Exception {
        super(filePath);
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
        return new QuoteEntity[amount];
    }
}
