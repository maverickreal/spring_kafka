package com.maverick.kafka.logic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.maverick.kafka.data.models.TaskStatus;
import lombok.extern.java.Log;

@Service
@Log
public class KafkaProducerService {
    private final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
    @Autowired
    private KafkaTemplate<String, TaskStatus> kafkaTemplate;

    public void send(String topic, String key, TaskStatus value) {
        var future = kafkaTemplate.send(topic, key, value);
        future.whenComplete((res, err) -> {
            if (err != null) {
                future.completeExceptionally(err);
            } else {
                future.complete(res);
            }
            logger.info("Task status sent to kafka topic.");
        });
    }
}