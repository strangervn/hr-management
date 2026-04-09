package com.example.hrm.department.service;

import com.example.hrm.department.dto.*;
import com.example.hrm.department.entity.*;
import com.example.hrm.employee.entity.*;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository repository;
    private final PositionMapper mapper;

    @Transactional(readOnly = true)
    public List<PositionDTO> findAll() {
        return repository.findAll().stream()
            .filter(p -> !p.isDeleted())
            .map(mapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public PositionDTO save(PositionDTO dto) {
        Position saved = repository.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }
}
