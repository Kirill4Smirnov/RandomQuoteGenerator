package model;

import java.util.ArrayList;

public interface RegenObserver {
    public ArrayList<String> getCategories();
    public QuoteEntity[] getRandomQuotes(int amount);
    public QuoteEntity[] getRandomQuotes(String category, int amount);
    public QuoteEntity[] getRandomQuotes(String author, String category, int amount);
}
