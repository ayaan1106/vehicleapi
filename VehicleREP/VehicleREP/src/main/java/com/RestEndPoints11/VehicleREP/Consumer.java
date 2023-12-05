package com.RestEndPoints11.VehicleREP;import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private Repo repo;

    @KafkaListener(topics = "assgntopic", groupId = "assgngrp")
    public void consume(User user){
        LOGGER.info(String.format("Json message received -> %s", user.toString()));


        Message message = new Message();
        message.setMessage(user.toString());
        repo.save(message);
    }
}