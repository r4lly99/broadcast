package broadcast.utils;

import broadcast.model.Stock;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFiles {



    public void ReadTheFile() throws URISyntaxException {
        File file = getFileFromResource("test3.txt");
        String filePath = file.getAbsolutePath();

        String content = null;
        try {
            content = readFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(content != null && content.contains("|")){
            String[] splitContent = content.split("\\|");
            Stock stock = new Stock(splitContent[0], splitContent[1], splitContent[2]);
//            stockProducer.sendStockToKafka(stock);
        }
    }

    public File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());
            return new File(resource.toURI());
        }

    }

    public static String readFile(String path) throws IOException {
        return Files.readString(Paths.get(path));
    }


}
