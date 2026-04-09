package com.example.hrm.employee.mapper;

import com.example.hrm.department.entity.Department;
import com.example.hrm.department.entity.Position;
import com.example.hrm.employee.dto.EmployeeDTO;
import com.example.hrm.employee.entity.Employee;
import com.example.hrm.users.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-10T01:38:34+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDTO toDto(Employee entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setUserId( entityUserId( entity ) );
        employeeDTO.setDepartmentId( entityDepartmentId( entity ) );
        employeeDTO.setPositionId( entityPositionId( entity ) );
        employeeDTO.setFirstName( entity.getFirstName() );
        employeeDTO.setHireDate( entity.getHireDate() );
        employeeDTO.setId( entity.getId() );
        employeeDTO.setLastName( entity.getLastName() );
        employeeDTO.setPhone( entity.getPhone() );
        employeeDTO.setSalary( entity.getSalary() );

        return employeeDTO;
    }

    @Override
    public Employee toEntity(EmployeeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.firstName( dto.getFirstName() );
        employee.hireDate( dto.getHireDate() );
        employee.id( dto.getId() );
        employee.lastName( dto.getLastName() );
        employee.phone( dto.getPhone() );
        employee.salary( dto.getSalary() );

        return employee.build();
    }

    private Long entityUserId(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        User user = employee.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityDepartmentId(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Department department = employee.getDepartment();
        if ( department == null ) {
            return null;
        }
        Long id = department.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityPositionId(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Position position = employee.getPosition();
        if ( position == null ) {
            return null;
        }
        Long id = position.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
