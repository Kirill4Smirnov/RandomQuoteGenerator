package model;


import com.opencsv.CSVReader;

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

    private List<String[]> readAllLines(Path filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                return csvReader.readAll();
            }
        }
    }

    public String[][] getNLines(int amount) throws Exception {
        Path path = Paths.get(
                ClassLoader.getSystemResource("/home/kenlog/Downloads/MotivationalQuotesDatabase.csv").toURI());
        List<String[]> allLinesList =  readAllLines(path);
        String[][] resultList = new String[amount][3];
        for (int i = 0; i < amount; i++) {
            resultList[i] = allLinesList.get(i);
        }

        return resultList;
    }
}
