package model;

import java.util.ArrayList;

public class DB_Quote_Reader implements QuoteReader {
    public DB_Quote_Reader(){};

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
    public String[][] getNLines(int amount) throws Exception {
        return new String[0][];
    }
}
