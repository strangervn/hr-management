package com.example.hrm.users.service;

import com.example.hrm.users.dto.*;
import com.example.hrm.users.entity.*;
import com.example.hrm.employee.entity.*;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository repository;
    private final RoleMapper mapper;

    @Transactional(readOnly = true)
    public List<RoleDTO> findAll() {
        return repository.findAll().stream()
            .filter(r -> !r.isDeleted())
            .map(mapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public RoleDTO save(RoleDTO dto) {
        Role saved = repository.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }
}
