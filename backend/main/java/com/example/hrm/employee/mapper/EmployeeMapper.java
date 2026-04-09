package com.example.hrm.employee.mapper;

import com.example.hrm.employee.dto.*;
import com.example.hrm.employee.entity.*;
import com.example.hrm.department.repository.*;
import com.example.hrm.users.repository.*;
import com.example.hrm.department.entity.*;
import com.example.hrm.users.entity.*;
import com.example.hrm.tasks.entity.*;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "departmentId", source = "department.id")
    @Mapping(target = "positionId", source = "position.id")
    EmployeeDTO toDto(Employee entity);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "department", ignore = true)
    @Mapping(target = "position", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    @Mapping(target = "attendances", ignore = true)
    @Mapping(target = "leaveRequests", ignore = true)
    Employee toEntity(EmployeeDTO dto);
}
