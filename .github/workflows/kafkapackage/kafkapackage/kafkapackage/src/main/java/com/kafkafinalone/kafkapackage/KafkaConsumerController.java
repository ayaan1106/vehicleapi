package com.kafkafinalone.kafkapackage;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consume")
public class KafkaConsumerController {

    private final KafkaConsumerService kafkaConsumerService;
    private final Repository yourRepository;

    public KafkaConsumerController(
            KafkaConsumerService kafkaConsumerService,
            Repository yourRepository) {
        this.kafkaConsumerService = kafkaConsumerService;
        this.yourRepository = yourRepository;
    }

    @PostMapping
    public String consumeMessages() {

        return "Consuming messages from Kafka topic...";
    }

    @PostMapping("/add")
    public Entity createEntity(@RequestBody Entity entity) {
        return yourRepository.save(entity);
    }
}
