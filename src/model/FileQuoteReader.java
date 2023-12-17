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

public class FileQuoteReader implements QuoteReader {


    public ArrayList<String> getCategories() {
        return null;
    }


    public QuoteEntity getQuote(String category) {
        return null;
    }

    private List<String[]> readAllLines(Path filePath, char sep) throws Exception {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withCSVParser(new CSVParserBuilder()
                            .withSeparator(sep)
                            .build()
                    ).build()) {
                return csvReader.readAll();
            }
        }
    }

    public String[][] getNLines(int amount) throws Exception {
        Path path = Paths.get(
                ClassLoader.getSystemResource("resources/MotivationalQuotesDatabase.csv").toURI());
        List<String[]> allLinesList =  readAllLines(path, ';');
        String[][] resultList = new String[amount][3];
        for (int i = 0; i < amount; i++) {
            resultList[i] = allLinesList.get(i);
        }

        return resultList;
    }
}
