package com.example.hrm.department.service;

import com.example.hrm.department.dto.*;
import com.example.hrm.department.entity.*;
import com.example.hrm.employee.entity.*;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;

    @Transactional(readOnly = true)
    public List<DepartmentDTO> findAll() {
        return repository.findAll().stream()
            .filter(d -> !d.isDeleted())
            .map(mapper::toDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<DepartmentDTO> findById(Long id) {
        return repository.findById(id).filter(d -> !d.isDeleted()).map(mapper::toDto);
    }

    @Transactional
    public DepartmentDTO save(DepartmentDTO dto) {
        Department saved = repository.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }
}
