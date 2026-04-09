package com.example.hrm.tasks.mapper;

import com.example.hrm.employee.entity.Employee;
import com.example.hrm.tasks.dto.TaskDTO;
import com.example.hrm.tasks.entity.Task;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-10T01:38:34+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDTO toDto(Task entity) {
        if ( entity == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setEmployeeId( entityEmployeeId( entity ) );
        taskDTO.setCreatedAt( entity.getCreatedAt() );
        taskDTO.setDescription( entity.getDescription() );
        taskDTO.setId( entity.getId() );
        taskDTO.setStatus( entity.getStatus() );
        taskDTO.setTitle( entity.getTitle() );

        return taskDTO;
    }

    @Override
    public Task toEntity(TaskDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Task.TaskBuilder task = Task.builder();

        task.createdAt( dto.getCreatedAt() );
        task.description( dto.getDescription() );
        task.id( dto.getId() );
        task.status( dto.getStatus() );
        task.title( dto.getTitle() );

        return task.build();
    }

    private Long entityEmployeeId(Task task) {
        if ( task == null ) {
            return null;
        }
        Employee employee = task.getEmployee();
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
