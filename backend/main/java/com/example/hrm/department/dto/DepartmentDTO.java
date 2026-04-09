package com.example.hrm.department.dto;

import com.example.hrm.department.dto.*;
import com.example.hrm.department.entity.*;
import com.example.hrm.employee.entity.*;


import lombok.Data;

@Data
public class DepartmentDTO {
    private Long id;
    private String name;
    private String description;
}
