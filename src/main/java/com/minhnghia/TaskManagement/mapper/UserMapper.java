package com.minhnghia.TaskManagement.mapper;

import com.minhnghia.TaskManagement.dto.request.UserCreationRequest;
import com.minhnghia.TaskManagement.dto.request.UserUpdateRequest;
import com.minhnghia.TaskManagement.dto.response.UserResponse;
import com.minhnghia.TaskManagement.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
