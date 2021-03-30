package broadcast.kafka;

import broadcast.model.Stock;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.messaging.annotation.MessageBody;

@KafkaClient
public interface Producer {

    @Topic("stocks")
    void sendStocks(@MessageBody Stock stock);

}