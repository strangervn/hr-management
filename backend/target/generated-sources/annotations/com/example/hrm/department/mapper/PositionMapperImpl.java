package com.example.hrm.department.mapper;

import com.example.hrm.department.dto.PositionDTO;
import com.example.hrm.department.entity.Position;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-10T01:38:34+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class PositionMapperImpl implements PositionMapper {

    @Override
    public PositionDTO toDto(Position entity) {
        if ( entity == null ) {
            return null;
        }

        PositionDTO positionDTO = new PositionDTO();

        positionDTO.setBaseSalary( entity.getBaseSalary() );
        positionDTO.setDescription( entity.getDescription() );
        positionDTO.setId( entity.getId() );
        positionDTO.setTitle( entity.getTitle() );

        return positionDTO;
    }

    @Override
    public Position toEntity(PositionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Position.PositionBuilder position = Position.builder();

        position.baseSalary( dto.getBaseSalary() );
        position.description( dto.getDescription() );
        position.id( dto.getId() );
        position.title( dto.getTitle() );

        return position.build();
    }
}
