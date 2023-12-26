package view;

import model.QuoteEntity;

public class ConsoleUI implements UI {

    @Override
    public void showQuotes(QuoteEntity[] quotes) {

        for (QuoteEntity quoteEntity : quotes) {
            System.out.println(quoteEntity.text() + "|" + quoteEntity.author() + "|" + quoteEntity.category() + '\n');
        }


    }

    @Override
    public void showCategories() {

    }
}
