package model;

import java.util.ArrayList;

public abstract class QuoteReader {
    protected String filePath;
    public QuoteReader(String filePath) throws Exception{
        this.filePath = filePath;
    }

    public abstract ArrayList<String> getCategories() throws Exception;


    public abstract QuoteEntity[] getFirstLines(int amount)throws Exception;

    public abstract QuoteEntity[] getRandomQuotes(int num) throws Exception;

    public abstract QuoteEntity[] getRandomQuotes(String category, int num) throws Exception;

    public abstract QuoteEntity[] getRandomQuotes(String author, String category, int num) throws Exception;
}
