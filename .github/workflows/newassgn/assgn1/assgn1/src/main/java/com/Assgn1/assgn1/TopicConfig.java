package com.Assgn1.assgn1;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration

public class TopicConfig {

    @Bean
    public NewTopic createtopic(){
        return TopicBuilder.name("assgntopic").build();
    }
}
