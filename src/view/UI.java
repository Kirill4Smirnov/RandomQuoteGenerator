package view;

import model.QuoteEntity;
import model.RegenObserver;

import java.util.ArrayList;

public interface UI {
    void showQuotes(QuoteEntity[] quotes);

    void showCategories(ArrayList<String> categories);

    public void subscribeForRegenEvent(RegenObserver observer);
}
