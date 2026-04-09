package com.example.hrm.department.dto;

import com.example.hrm.department.dto.*;
import com.example.hrm.department.entity.*;
import com.example.hrm.employee.entity.*;


import lombok.Data;

@Data
public class PositionDTO {
    private Long id;
    private String title;
    private String description;
    private Double baseSalary;
}
