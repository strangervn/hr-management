package com.example.hrm.tasks.repository;

import com.example.hrm.tasks.dto.*;
import com.example.hrm.tasks.entity.*;
import com.example.hrm.employee.entity.*;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByEmployeeId(Long employeeId);
}
