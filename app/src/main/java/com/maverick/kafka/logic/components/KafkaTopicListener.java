package com.maverick.kafka.logic.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.maverick.kafka.data.models.TaskStatus;
import lombok.extern.java.Log;

@Component
@Log
public class KafkaTopicListener {
    private final Logger logger = LoggerFactory.getLogger(KafkaTopicListener.class);

    @KafkaListener(topics = { "general-task-topic" }, groupId = "task-group")
    public void consume(TaskStatus taskStatus) {
        logger.info("Task status is updated : " + taskStatus);
    }
}