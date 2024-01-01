package view;

import model.QuoteEntity;
import model.RegenObserver;

import java.util.ArrayList;

public interface UI {
    void showQuotes(QuoteEntity[] quotes);

    public void subscribeForRegenEvent(RegenObserver observer);
}
