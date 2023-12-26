package model;

import java.util.ArrayList;

public class Model {
    private final QuoteReader reader;
    public Model() {
        try {
            reader = new DB_Quote_Reader("resources/quotes.db");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public QuoteEntity[] getFirstQuotes(int amount){
        try {
            return reader.getFirstLines(amount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

   public ArrayList<String> getCategories(){
        try {
            return reader.getCategories();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

   }
}
