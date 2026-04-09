package com.example.hrm.users.dto;

import com.example.hrm.users.dto.*;
import com.example.hrm.users.entity.*;
import com.example.hrm.employee.entity.*;


import lombok.Data;
import java.util.Set;

@Data
public class RoleDTO {
    private Long id;
    private String name;
    private String description;
    private Set<String> permissions;
}
