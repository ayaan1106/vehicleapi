package com.kafkafinalone.kafkapackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
@EnableConfigurationProperties
public class KafkapackageApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkapackageApplication.class, args);
	}

}
