package com.example.hrm.users.service;

import com.example.hrm.users.dto.*;
import com.example.hrm.users.entity.*;
import com.example.hrm.employee.entity.*;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        return repository.findAll().stream()
                .filter(user -> !user.isDeleted())
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<UserDTO> findById(Long id) {
        return repository.findById(id)
                .filter(user -> !user.isDeleted())
                .map(mapper::toDto);
    }

    @Transactional(readOnly = true)
    public Optional<UserDTO> findByUsername(String username) {
        return repository.findByUsername(username)
                .filter(user -> !user.isDeleted())
                .map(mapper::toDto);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.findById(id).ifPresent(user -> {
            user.setDeleted(true);
            repository.save(user);
        });
    }
}
