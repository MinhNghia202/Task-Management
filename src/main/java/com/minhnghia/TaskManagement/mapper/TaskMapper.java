package com.minhnghia.TaskManagement.mapper;

import com.minhnghia.TaskManagement.dto.request.TaskCreationRequest;
import com.minhnghia.TaskManagement.dto.request.TaskUpdateRequest;
import com.minhnghia.TaskManagement.dto.response.TaskResponse;
import com.minhnghia.TaskManagement.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toTask(TaskCreationRequest request);

    TaskResponse toTaskResponse(Task task);

    void updateTask (@MappingTarget Task task, TaskUpdateRequest request);
}
