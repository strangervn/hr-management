package com.example.hrm.employee.mapper;

import com.example.hrm.employee.dto.LeaveRequestDTO;
import com.example.hrm.employee.entity.Employee;
import com.example.hrm.employee.entity.LeaveRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-10T01:38:34+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class LeaveRequestMapperImpl implements LeaveRequestMapper {

    @Override
    public LeaveRequestDTO toDto(LeaveRequest entity) {
        if ( entity == null ) {
            return null;
        }

        LeaveRequestDTO leaveRequestDTO = new LeaveRequestDTO();

        leaveRequestDTO.setEmployeeId( entityEmployeeId( entity ) );
        leaveRequestDTO.setEndDate( entity.getEndDate() );
        leaveRequestDTO.setId( entity.getId() );
        leaveRequestDTO.setLeaveType( entity.getLeaveType() );
        leaveRequestDTO.setReason( entity.getReason() );
        leaveRequestDTO.setStartDate( entity.getStartDate() );
        leaveRequestDTO.setStatus( entity.getStatus() );

        return leaveRequestDTO;
    }

    @Override
    public LeaveRequest toEntity(LeaveRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        LeaveRequest.LeaveRequestBuilder leaveRequest = LeaveRequest.builder();

        leaveRequest.endDate( dto.getEndDate() );
        leaveRequest.id( dto.getId() );
        leaveRequest.leaveType( dto.getLeaveType() );
        leaveRequest.reason( dto.getReason() );
        leaveRequest.startDate( dto.getStartDate() );
        leaveRequest.status( dto.getStatus() );

        return leaveRequest.build();
    }

    private Long entityEmployeeId(LeaveRequest leaveRequest) {
        if ( leaveRequest == null ) {
            return null;
        }
        Employee employee = leaveRequest.getEmployee();
        if ( employee == null ) {
            return null;
        }
        Long id = employee.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
