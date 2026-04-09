package com.example.hrm.department.mapper;

import com.example.hrm.department.dto.*;
import com.example.hrm.department.entity.*;
import com.example.hrm.employee.entity.*;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentMapper {
    DepartmentDTO toDto(Department entity);
    
    @Mapping(target = "employees", ignore = true)
    Department toEntity(DepartmentDTO dto);
}
