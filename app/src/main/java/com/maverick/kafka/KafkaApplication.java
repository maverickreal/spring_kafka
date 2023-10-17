package com.maverick.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import com.maverick.kafka.data.models.TaskStatus;

@SpringBootApplication
public class KafkaApplication implements CommandLineRunner {
	@Autowired
	KafkaTemplate<String, TaskStatus> producer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		producer.send("general-task-topic", "taskId", new TaskStatus(
				"taskId", "taskName", 12.34, TaskStatus.Status.RUNNING)).whenComplete((res, err) -> {
					System.out.println("herez.");
				});
		System.out.println("herex.");
		producer.send("general-task-topic", "taskId2", new TaskStatus(
				"taskId2", "taskName2", 43.21, TaskStatus.Status.FINISHED)).whenComplete((res, err) -> {
					System.out.println("herez.");
				});
	}
}