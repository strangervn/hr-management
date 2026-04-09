package com.example.hrm.users.mapper;

import com.example.hrm.users.dto.*;
import com.example.hrm.users.entity.*;
import com.example.hrm.employee.entity.*;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {
    @Mapping(target = "permissions", source = "permissions", qualifiedByName = "mapPerms")
    RoleDTO toDto(Role entity);

    @Mapping(target = "permissions", ignore = true)
    @Mapping(target = "users", ignore = true)
    Role toEntity(RoleDTO dto);

    @Named("mapPerms")
    default Set<String> mapPerms(Set<Permission> perms) {
        if (perms == null) return null;
        return perms.stream().map(Permission::getName).collect(Collectors.toSet());
    }
}
