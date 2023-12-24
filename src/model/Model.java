package model;

public class Model {
    private final QuoteReader reader;
    public Model() {
        try {
            reader = new DB_Quote_Reader("resources/quotes.db");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void printQuotes(int amount){
            QuoteEntity[] quotesArr;

        try {
            quotesArr = reader.getNLines(10);

            for (QuoteEntity quoteEntity : quotesArr) {
                System.out.println(quoteEntity.text() + "|" + quoteEntity.author() + "|" + quoteEntity.category() + '\n');
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
