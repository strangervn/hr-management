package com.example.hrm.tasks.dto;

import com.example.hrm.tasks.dto.*;
import com.example.hrm.tasks.entity.*;
import com.example.hrm.employee.entity.*;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TaskDTO {
    private Long id;
    private Long employeeId;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;
}
