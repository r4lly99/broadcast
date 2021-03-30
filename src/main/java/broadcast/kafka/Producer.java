package broadcast.kafka;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface Producer {

    @Topic("my-products")
    void sendProduct(@KafkaKey String brand, String name);

    void sendProduct(@Topic String topic, @KafkaKey String brand, String name);

}