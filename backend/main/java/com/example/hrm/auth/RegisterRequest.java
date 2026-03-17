package com.example.hrm.auth;

import lombok.Data;

import java.util.Set;

@Data
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private String role; // e.g., "ADMIN", "HR", "EMPLOYEE"
}
