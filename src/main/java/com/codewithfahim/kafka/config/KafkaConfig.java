package com.codewithfahim.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.json-topic.name}")
    private String jsonTopicName;

    // creates new kafka topic
    @Bean
    public NewTopic kafkaTopic() {
        return TopicBuilder.name(topicName)           // .partition(10) -> it splits the kafka topic
                .build();
    }

    @Bean
    public NewTopic jsonKafkaTopic() {
        return TopicBuilder.name(jsonTopicName)        // .partition(10) -> it splits the kafka topic
                .build();
    }
}
