package com.example.hrm.tasks.mapper;

import com.example.hrm.tasks.dto.*;
import com.example.hrm.tasks.entity.*;
import com.example.hrm.employee.entity.*;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {
    @Mapping(target = "employeeId", source = "employee.id")
    TaskDTO toDto(Task entity);

    @Mapping(target = "employee", ignore = true)
    Task toEntity(TaskDTO dto);
}
