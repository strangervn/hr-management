package com.example.hrm.employee.service;

import com.example.hrm.employee.dto.*;
import com.example.hrm.employee.entity.*;
import com.example.hrm.department.repository.*;
import com.example.hrm.users.repository.*;
import com.example.hrm.department.entity.*;
import com.example.hrm.users.entity.*;
import com.example.hrm.tasks.entity.*;


import com.example.hrm.exception.ResourceNotFoundException;
import com.example.hrm.department.DepartmentRepository;
import com.example.hrm.department.PositionRepository;
import com.example.hrm.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;

    @Transactional(readOnly = true)
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .filter(e -> !e.isDeleted())
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        if (employee.isDeleted()) throw new ResourceNotFoundException("Employee is deleted");
        return employeeMapper.toDto(employee);
    }

    @Transactional
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        if (employeeDTO.getPhone() != null && employeeRepository.existsByPhone(employeeDTO.getPhone())) {
            throw new IllegalArgumentException("Phone number already exists");
        }

        Employee employee = employeeMapper.toEntity(employeeDTO);
        linkForeignRelations(employeeDTO, employee);

        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDto(savedEmployee);
    }

    @Transactional
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
                
        // Only update if phone changed
        if (employeeDTO.getPhone() != null && !employeeDTO.getPhone().equals(employee.getPhone())) {
            if (employeeRepository.existsByPhone(employeeDTO.getPhone())) {
                throw new IllegalArgumentException("Phone number already exists");
            }
        }

        // Map base variables safely
        if(employeeDTO.getFirstName() != null) employee.setFirstName(employeeDTO.getFirstName());
        if(employeeDTO.getLastName() != null) employee.setLastName(employeeDTO.getLastName());
        if(employeeDTO.getPhone() != null) employee.setPhone(employeeDTO.getPhone());
        employee.setHireDate(employeeDTO.getHireDate());
        employee.setSalary(employeeDTO.getSalary());

        linkForeignRelations(employeeDTO, employee);

        Employee updatedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDto(updatedEmployee);
    }

    @Transactional
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employee.setDeleted(true);
        employeeRepository.save(employee);
    }
    
    // Abstracted rel linking to avoid select logic
    private void linkForeignRelations(EmployeeDTO dto, Employee employee) {
        if (dto.getUserId() != null) {
            employee.setUser(userRepository.getReferenceById(dto.getUserId()));
        }
        if (dto.getDepartmentId() != null) {
            employee.setDepartment(departmentRepository.getReferenceById(dto.getDepartmentId()));
        }
        if (dto.getPositionId() != null) {
            employee.setPosition(positionRepository.getReferenceById(dto.getPositionId()));
        }
    }
}
