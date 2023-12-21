package model;

import java.util.List;

public class Model {
    private final QuoteReader reader;
    public Model() {
        try {
            reader = new FileQuoteReader("resources/MotivationalQuotesDatabase.csv");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void printQuotes(int amount){
            QuoteEntity[] quotesArr;

        try {
            quotesArr = reader.getNLines(10);

            for (QuoteEntity quoteEntity : quotesArr) {
                System.out.println(quoteEntity.getText() + "|" + quoteEntity.getAuthor() + "|" + quoteEntity.getCategory() + '\n');
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
