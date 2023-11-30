package model;

import java.util.ArrayList;
import java.util.List;

public class DB_Communicator {
    public DB_Communicator(){};

    public ArrayList<String> getCategories(){
        ArrayList<String> categories = new ArrayList<String>();

        // get categories from the DB, do something with "categories"

        return categories;
    }

    public QuoteEntity getQuote(String category){
        // TODO make this method, now it is just a stub
        return new QuoteEntity("sample text", "sample author", category);
    }
}
