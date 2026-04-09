package com.example.hrm.users.dto;

import com.example.hrm.users.dto.*;
import com.example.hrm.users.entity.*;
import com.example.hrm.employee.entity.*;


import lombok.Data;
import java.util.Set;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    // Password intentionally excluded for security
    private boolean enabled;
    private boolean accountNonLocked;
    
    // We only expose role names to the client, not the whole role object
    private Set<String> roles;
}
