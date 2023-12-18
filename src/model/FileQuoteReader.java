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

public class FileQuoteReader extends QuoteReader {
    public FileQuoteReader(String filePath){
        super(filePath);


    }

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

    public QuoteEntity[] getNLines(int amount) throws Exception {
        Path path = Paths.get(
                ClassLoader.getSystemResource(filePath).toURI());
        List<String[]> allLinesList =  readAllLines(path, ';');
        QuoteEntity[] resultList = new QuoteEntity[amount];

        String[] currentString = new String[3];
        for (int i = 0; i < amount; i++) {
            currentString = allLinesList.get(i);
            resultList[i] = new QuoteEntity(currentString[0], currentString[1], currentString[2]);
        }

        return resultList;
    }
}
