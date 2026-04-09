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
public class LeaveRequestService {
    private final LeaveRequestRepository repository;
    private final LeaveRequestMapper mapper;

    @Transactional(readOnly = true)
    public List<LeaveRequestDTO> findAll() {
        return repository.findAll().stream()
            .filter(l -> !l.isDeleted())
            .map(mapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public LeaveRequestDTO save(LeaveRequestDTO dto) {
        LeaveRequest saved = repository.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }
}
