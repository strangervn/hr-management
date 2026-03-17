package com.example.hrm.security;

import com.example.hrm.employee.Employee;
import com.example.hrm.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("securityService")
@RequiredArgsConstructor
public class SecurityService {

    private final EmployeeRepository employeeRepository;

    public boolean isPrincipalEmployeeId(Long employeeId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails userDetails) {
            Optional<Employee> employeeOpt = employeeRepository.findByUserId(userDetails.getId());
            return employeeOpt.isPresent() && employeeOpt.get().getId().equals(employeeId);
        }

        return false;
    }
}
