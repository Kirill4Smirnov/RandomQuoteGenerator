package model;

import java.util.ArrayList;

public abstract class QuoteReader {
    protected String filePath;
    public QuoteReader(String filePath) throws Exception{
        this.filePath = filePath;
    }

    public abstract ArrayList<String> getCategories();

    public abstract QuoteEntity getQuote(String category);

    public abstract QuoteEntity[] getNLines(int amount)throws Exception;
}
