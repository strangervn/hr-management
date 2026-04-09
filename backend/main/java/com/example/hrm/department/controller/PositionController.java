package com.example.hrm.department.controller;

import com.example.hrm.department.dto.*;
import com.example.hrm.department.entity.*;
import com.example.hrm.employee.entity.*;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/positions")
@RequiredArgsConstructor
public class PositionController {
    private final PositionService service;

    @GetMapping
    public ResponseEntity<List<PositionDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<PositionDTO> create(@RequestBody PositionDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}
