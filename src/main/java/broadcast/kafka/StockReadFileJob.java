package broadcast.kafka;

import io.micronaut.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.text.SimpleDateFormat;
import java.util.Date;

@Singleton
public class StockReadFileJob {

    private static final Logger LOG = LoggerFactory.getLogger(StockReadFileJob.class);

    @Inject
    Producer broadcast;

    @Scheduled(fixedDelay = "45s", initialDelay = "5s")
    void executeEveryFourtyFive() {
        LOG.info("Simple Job every 45 seconds: {}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()));
        broadcast.sendProduct("Nike", "Blue Trainers");
    }
}
