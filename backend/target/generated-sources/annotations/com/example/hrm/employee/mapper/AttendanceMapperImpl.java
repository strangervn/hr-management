package com.example.hrm.employee.mapper;

import com.example.hrm.employee.dto.AttendanceDTO;
import com.example.hrm.employee.entity.Attendance;
import com.example.hrm.employee.entity.Employee;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-10T01:38:34+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class AttendanceMapperImpl implements AttendanceMapper {

    @Override
    public AttendanceDTO toDto(Attendance entity) {
        if ( entity == null ) {
            return null;
        }

        AttendanceDTO attendanceDTO = new AttendanceDTO();

        attendanceDTO.setEmployeeId( entityEmployeeId( entity ) );
        attendanceDTO.setCheckInTime( entity.getCheckInTime() );
        attendanceDTO.setCheckOutTime( entity.getCheckOutTime() );
        attendanceDTO.setId( entity.getId() );
        attendanceDTO.setStatus( entity.getStatus() );
        attendanceDTO.setWorkDate( entity.getWorkDate() );

        return attendanceDTO;
    }

    @Override
    public Attendance toEntity(AttendanceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Attendance.AttendanceBuilder attendance = Attendance.builder();

        attendance.checkInTime( dto.getCheckInTime() );
        attendance.checkOutTime( dto.getCheckOutTime() );
        attendance.id( dto.getId() );
        attendance.status( dto.getStatus() );
        attendance.workDate( dto.getWorkDate() );

        return attendance.build();
    }

    private Long entityEmployeeId(Attendance attendance) {
        if ( attendance == null ) {
            return null;
        }
        Employee employee = attendance.getEmployee();
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
