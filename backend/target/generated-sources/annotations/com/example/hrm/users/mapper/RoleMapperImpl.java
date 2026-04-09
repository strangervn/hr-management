package com.example.hrm.users.mapper;

import com.example.hrm.users.dto.RoleDTO;
import com.example.hrm.users.entity.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-10T01:38:33+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDTO toDto(Role entity) {
        if ( entity == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setPermissions( mapPerms( entity.getPermissions() ) );
        roleDTO.setDescription( entity.getDescription() );
        roleDTO.setId( entity.getId() );
        roleDTO.setName( entity.getName() );

        return roleDTO;
    }

    @Override
    public Role toEntity(RoleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        role.description( dto.getDescription() );
        role.id( dto.getId() );
        role.name( dto.getName() );

        return role.build();
    }
}
