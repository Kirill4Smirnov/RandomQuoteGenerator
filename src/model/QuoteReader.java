package model;

import java.util.ArrayList;

public interface QuoteReader {

    public ArrayList<String> getCategories();
    public QuoteEntity getQuote(String category);

    public String[][] getNLines(int amount)throws Exception;
}
