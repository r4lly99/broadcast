package broadcast.job;

import broadcast.kafka.Producer;
import broadcast.model.Stock;
import broadcast.utils.ReadFiles;
import io.micronaut.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Singleton
public class ReadFileJob {

    private static final Logger LOG = LoggerFactory.getLogger(ReadFileJob.class);

    @Inject
    Producer broadcast;

    @Scheduled(fixedDelay = "45s", initialDelay = "5s")
    void executeEveryFourtyFive() {
        LOG.info("Simple Job every 45 seconds: {}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()));
        List<Stock> stockList = proceedFileIntoObj();
        if (stockList.size() > 0) {
            for (Stock stock: stockList) {
                broadcast.sendStocks(stock);
            }
        }
    }

    private List<Stock> proceedFileIntoObj() {
        List<Stock> stockList = new ArrayList<>();
        ReadFiles readFiles = new ReadFiles();
        try {
            stockList = readFiles.convertFileIntoObj();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return stockList;
    }

}
