package com.example.hrm.employee.service;

import com.example.hrm.employee.dto.*;
import com.example.hrm.employee.entity.*;
import com.example.hrm.department.repository.*;
import com.example.hrm.users.repository.*;
import com.example.hrm.department.entity.*;
import com.example.hrm.users.entity.*;
import com.example.hrm.tasks.entity.*;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceRepository repository;
    private final AttendanceMapper mapper;

    @Transactional(readOnly = true)
    public List<AttendanceDTO> findAll() {
        return repository.findAll().stream()
            .filter(a -> !a.isDeleted())
            .map(mapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public AttendanceDTO save(AttendanceDTO dto) {
        Attendance saved = repository.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }
}
