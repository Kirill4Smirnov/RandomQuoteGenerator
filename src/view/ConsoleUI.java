package view;

import model.QuoteEntity;
import java.util.ArrayList;


public class ConsoleUI implements UI {

    @Override
    public void showQuotes(QuoteEntity[] quotes) {

        for (QuoteEntity quoteEntity : quotes) {
            System.out.println(quoteEntity.text() + "|" + quoteEntity.author() + "|" + quoteEntity.category() + '\n');
        }


    }

    @Override
    public void showCategories(ArrayList<String> categories) {
        int idx = 0;
        for (String category : categories) {
            System.out.println(Integer.toString(idx) + ": " + category);
            idx++;
        }
    }
}
