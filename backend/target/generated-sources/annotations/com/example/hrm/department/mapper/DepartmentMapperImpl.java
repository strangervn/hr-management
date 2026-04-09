package com.example.hrm.department.mapper;

import com.example.hrm.department.dto.DepartmentDTO;
import com.example.hrm.department.entity.Department;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-10T01:38:34+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentDTO toDto(Department entity) {
        if ( entity == null ) {
            return null;
        }

        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setDescription( entity.getDescription() );
        departmentDTO.setId( entity.getId() );
        departmentDTO.setName( entity.getName() );

        return departmentDTO;
    }

    @Override
    public Department toEntity(DepartmentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Department.DepartmentBuilder department = Department.builder();

        department.description( dto.getDescription() );
        department.id( dto.getId() );
        department.name( dto.getName() );

        return department.build();
    }
}
