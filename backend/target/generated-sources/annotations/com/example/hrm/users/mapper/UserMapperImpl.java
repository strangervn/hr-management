package com.example.hrm.users.mapper;

import com.example.hrm.users.dto.UserDTO;
import com.example.hrm.users.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-10T01:38:34+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setRoles( mapRolesToStrings( entity.getRoles() ) );
        userDTO.setAccountNonLocked( entity.isAccountNonLocked() );
        userDTO.setEmail( entity.getEmail() );
        userDTO.setEnabled( entity.isEnabled() );
        userDTO.setId( entity.getId() );
        userDTO.setUsername( entity.getUsername() );

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.accountNonLocked( dto.isAccountNonLocked() );
        user.email( dto.getEmail() );
        user.enabled( dto.isEnabled() );
        user.id( dto.getId() );
        user.username( dto.getUsername() );

        return user.build();
    }
}
