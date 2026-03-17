package com.example.hrm.tasks;

import lombok.Data;

@Data
public class TaskDTO {
    private Long id;
    private Long employeeId;
    private String title;
    private String description;
    private TaskStatus status;
}
