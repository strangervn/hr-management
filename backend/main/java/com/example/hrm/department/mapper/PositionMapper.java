package com.example.hrm.department.mapper;

import com.example.hrm.department.dto.*;
import com.example.hrm.department.entity.*;
import com.example.hrm.employee.entity.*;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PositionMapper {
    PositionDTO toDto(Position entity);

    @Mapping(target = "employees", ignore = true)
    Position toEntity(PositionDTO dto);
}
