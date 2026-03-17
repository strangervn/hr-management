package com.example.hrm.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
