package controller;

import model.Model;
import model.RegenObserver;
import model.QuoteEntity;
import view.SwingUI;
import view.UI;

import java.util.ArrayList;

public class Controller implements RegenObserver {
    Model model;
    UI ui;

    public Controller(){
        model = new Model();
        ui = new SwingUI(this);
        //ui.subscribeForRegenEvent(this);
    }
    public void startProgram() {
        //ui.showQuotes(model.getRandomQuotes(1));
        //ui.showCategories(model.getCategories());
    }


    @Override
    public ArrayList<String> getCategories() {
        return model.getCategories();
    }

    @Override
    public QuoteEntity[] getRandomQuotes(int amount) {
        return model.getRandomQuotes(amount);
    }

    @Override
    public QuoteEntity[] getRandomQuotes(String category, int amount) {
        return model.getRandomQuotes(category, amount);
    }

    @Override
    public QuoteEntity[] getRandomQuotes(String author, String category, int amount) {
        return model.getRandomQuotes(author, category, amount);
    }
}
