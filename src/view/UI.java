package view;

import model.QuoteEntity;

import java.util.ArrayList;

public interface UI {
    void showQuotes(QuoteEntity[] quotes);

    void showCategories(ArrayList<String> categories);
}
