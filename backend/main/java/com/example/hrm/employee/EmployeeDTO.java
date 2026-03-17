package com.example.hrm.employee;

import lombok.Data;
import java.time.LocalDate;

@Data
public class EmployeeDTO {
    private Long id;
    private Long userId; // The associated user account
    private String firstName;
    private String lastName;
    private String position;
    private String phone;
    private LocalDate hireDate;
    private Double salary;
    private Long departmentId;
}
