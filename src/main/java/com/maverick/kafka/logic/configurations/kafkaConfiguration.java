package com.maverick.kafka.logic.configurations;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class kafkaConfiguration {
    @Bean
    public NewTopic getNewTopic() {
        return TopicBuilder.name("general-task-topic").partitions(1)
                .replicas(1).build();
    }
}