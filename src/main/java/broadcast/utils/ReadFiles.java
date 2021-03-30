package broadcast.utils;

import broadcast.model.Stock;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReadFiles {

    public List<Stock> convertFileIntoObj() throws URISyntaxException {

        List<Stock> stockList = new ArrayList<>();
        File file = getFileFromResource("test3.txt");

        try (Stream<String> lines = Files.lines(file.toPath(), Charset.defaultCharset())) {
            lines.forEachOrdered(content ->
            {
                if(content != null && content.contains("|")){
                    String[] splitContent = content.split("\\|");
                    if (splitContent.length > 0){
                        Stock stock = new Stock(splitContent[0].trim(), splitContent[1], splitContent[2]);
                        stockList.add(stock);
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stockList;
    }

    public File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }

    }

}
