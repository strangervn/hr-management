package com.example.hrm.employee.controller;

import com.example.hrm.employee.dto.*;
import com.example.hrm.employee.entity.*;
import com.example.hrm.department.repository.*;
import com.example.hrm.users.repository.*;
import com.example.hrm.department.entity.*;
import com.example.hrm.users.entity.*;
import com.example.hrm.tasks.entity.*;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/leave-requests")
@RequiredArgsConstructor
public class LeaveRequestController {
    private final LeaveRequestService service;

    @GetMapping
    public ResponseEntity<List<LeaveRequestDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<LeaveRequestDTO> create(@RequestBody LeaveRequestDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}
