package model;

import java.util.List;

public class Model {
    private final QuoteReader reader;
    public Model() {
        reader = new FileQuoteReader("resources/MotivationalQuotesDatabase.csv");
    }

    public List<List<String[]>> GetNQuotes(int amount){return null;}

    public void printQuotes(int amount){
            String[][] quotesArr;

        try {
            quotesArr = reader.getNLines(10);

            for (int i = 0; i < quotesArr.length; i++) {

                System.out.print("[");
                for (int j = 0; j < quotesArr[i].length; j++) {
                    System.out.print(" " + quotesArr[i][j] + ", ");
                }
                System.out.print("], \n");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
