package broadcast.kafka;

import broadcast.model.Stock;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.messaging.annotation.MessageBody;

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
public class Consumer {

    @Topic("stocks")
    public void receive(@MessageBody Stock stock) {
        System.out.println("Got Stock - " + stock);
    }

}