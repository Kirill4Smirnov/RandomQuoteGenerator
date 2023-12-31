package model;


import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



@Deprecated
// only reading all quotes works for now
public class FileQuoteReader extends QuoteReader {
    private final QuoteEntity[] allQuotesList;

    public FileQuoteReader(String filePath) throws Exception {
        super(filePath);

        List<String[]> allQuotesString = readAllLines();
        int size = allQuotesString.size();
        allQuotesList = new QuoteEntity[size];

        int idx = 0;
        for (String[] strings : allQuotesString) {
            if (strings.length == 3){
                allQuotesList[idx] = new QuoteEntity(strings[0], strings[1], strings[2]);
                ++idx;
            }
        }
    }

    public ArrayList<String> getCategories() {
        return null;
    }

    public QuoteEntity getQuote(String category) {
        return null;
    }

    private List<String[]> readAllLines() throws Exception {
        Path path = Paths.get(
                ClassLoader.getSystemResource(filePath).toURI());
        try (Reader reader = Files.newBufferedReader(path)) {
            try (CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withCSVParser(new CSVParserBuilder()
                            .withSeparator('|')
                            .build()
                    ).build()) {
                return csvReader.readAll();
            }
        }
    }

    public QuoteEntity[] getFirstLines(int amount) throws Exception {
        QuoteEntity[] resultArr = new QuoteEntity[amount];
        System.arraycopy(allQuotesList, 0, resultArr, 0, amount);
        return resultArr;
    }

    @Override
    public QuoteEntity[] getRandomQuotes(int num) {
        return null;
    }

    @Override
    public QuoteEntity[] getRandomQuotes(String category, int num) {
        return null;
    }

    @Override
    public QuoteEntity[] getRandomQuotes(String author, String category, int num) {
        return null;
    }
}
