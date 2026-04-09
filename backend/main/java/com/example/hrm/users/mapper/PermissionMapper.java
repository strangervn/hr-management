package com.example.hrm.users.mapper;

import com.example.hrm.users.dto.*;
import com.example.hrm.users.entity.*;
import com.example.hrm.employee.entity.*;


import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PermissionMapper {
    PermissionDTO toDto(Permission entity);
    Permission toEntity(PermissionDTO dto);
}
