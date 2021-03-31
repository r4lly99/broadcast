package broadcast;

import broadcast.dto.StockDTO;
import broadcast.kafka.Producer;
import broadcast.model.Stock;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@MicronautTest(environments = "kafka")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BroadcastEmbeddedTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BroadcastEmbeddedTest.class);

    @Inject
    Producer producer;

    @Test
    public void testBroadcastStockMessage() throws InterruptedException {
        LOGGER.info("testBroadcastStockMessage ");
        StockDTO stockDTO = new StockDTO("2021-Feb-24 10:50:34", "WIKA", "1810");
        Stock stock = new Stock().convertToEntity(stockDTO);
        producer.sendStocks(stock);
        Assertions.assertNotNull(stock);
    }

}
