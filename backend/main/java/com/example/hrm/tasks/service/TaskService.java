package com.example.hrm.tasks.service;

import com.example.hrm.tasks.dto.*;
import com.example.hrm.tasks.entity.*;
import com.example.hrm.employee.entity.*;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository repository;
    private final TaskMapper mapper;

    @Transactional(readOnly = true)
    public List<TaskDTO> findAll() {
        return repository.findAll().stream()
            .filter(t -> !t.isDeleted())
            .map(mapper::toDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<TaskDTO> findByEmployeeId(Long employeeId) {
        return repository.findByEmployeeId(employeeId).stream()
            .filter(t -> !t.isDeleted())
            .map(mapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public TaskDTO save(TaskDTO dto) {
        Task saved = repository.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }
}
