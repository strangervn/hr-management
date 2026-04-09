package com.example.hrm.users.mapper;

import com.example.hrm.users.dto.PermissionDTO;
import com.example.hrm.users.entity.Permission;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-10T01:38:34+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class PermissionMapperImpl implements PermissionMapper {

    @Override
    public PermissionDTO toDto(Permission entity) {
        if ( entity == null ) {
            return null;
        }

        PermissionDTO permissionDTO = new PermissionDTO();

        permissionDTO.setDescription( entity.getDescription() );
        permissionDTO.setId( entity.getId() );
        permissionDTO.setName( entity.getName() );

        return permissionDTO;
    }

    @Override
    public Permission toEntity(PermissionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Permission.PermissionBuilder permission = Permission.builder();

        permission.description( dto.getDescription() );
        permission.id( dto.getId() );
        permission.name( dto.getName() );

        return permission.build();
    }
}
