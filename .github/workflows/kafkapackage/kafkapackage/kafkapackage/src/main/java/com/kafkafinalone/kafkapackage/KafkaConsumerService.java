package com.kafkafinalone.kafkapackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @Autowired

    private final Repository newRepository;

    public KafkaConsumerService(Repository newRepository) {
        this.newRepository = newRepository;
    }

    @KafkaListener(topics = "aynk1", groupId = "console-consumer-34034")
    public void consume(String message) {


        Entity entity = new Entity();
        entity.setData(message);


        newRepository.save(entity);
    }
}
