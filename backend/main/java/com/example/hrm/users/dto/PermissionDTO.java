package com.example.hrm.users.dto;

import com.example.hrm.users.dto.*;
import com.example.hrm.users.entity.*;
import com.example.hrm.employee.entity.*;


import lombok.Data;

@Data
public class PermissionDTO {
    private Long id;
    private String name;
    private String description;
}
