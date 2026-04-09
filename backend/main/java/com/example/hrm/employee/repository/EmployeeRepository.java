package com.example.hrm.employee.repository;

import com.example.hrm.employee.dto.*;
import com.example.hrm.employee.entity.*;
import com.example.hrm.department.repository.*;
import com.example.hrm.users.repository.*;
import com.example.hrm.department.entity.*;
import com.example.hrm.users.entity.*;
import com.example.hrm.tasks.entity.*;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByPhone(String phone);
    Optional<Employee> findByPhone(String phone);
}
