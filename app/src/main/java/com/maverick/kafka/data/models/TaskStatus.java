package com.maverick.kafka.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskStatus implements Serializable {
    private String taskId, taskName;
    private double progress;
    private Status status;

    public static enum Status {
        SUBMITTED, STARTED, RUNNING, FINISHED, TERMINATED
    };
}