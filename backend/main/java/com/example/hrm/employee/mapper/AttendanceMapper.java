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
public interface AttendanceMapper {
    @Mapping(target = "employeeId", source = "employee.id")
    AttendanceDTO toDto(Attendance entity);

    @Mapping(target = "employee", ignore = true)
    Attendance toEntity(AttendanceDTO dto);
}
