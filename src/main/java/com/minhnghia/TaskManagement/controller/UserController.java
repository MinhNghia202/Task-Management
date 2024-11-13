package com.minhnghia.TaskManagement.controller;

import com.minhnghia.TaskManagement.dto.request.UserCreationRequest;
import com.minhnghia.TaskManagement.dto.request.UserUpdateRequest;
import com.minhnghia.TaskManagement.dto.response.ApiResponse;
import com.minhnghia.TaskManagement.dto.response.UserResponse;
import com.minhnghia.TaskManagement.entity.User;
import com.minhnghia.TaskManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request){
        return ApiResponse.<UserResponse>builder()
                .code(1000)
                .message("Create user is successfully!")
                .result(userService.createUser(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<UserResponse>> getUsers() {
        return ApiResponse.<List<UserResponse>>builder()
                .code(1000)
                .message("Get users is successfully!")
                .result(userService.getAllUsers())
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<UserResponse> getUserById(@PathVariable("id") String id){
        return ApiResponse.<UserResponse>builder()
                .code(1000)
                .message("Get user by id is successfully!")
                .result(userService.getUserById(id))
                .build();
    }

    @PostMapping("/{id}")
    ApiResponse<UserResponse> updateUser(@RequestBody @Valid UserUpdateRequest request, @PathVariable("id") String id){
        return ApiResponse.<UserResponse>builder()
                .code(1000)
                .message("Update user is successfully!")
                .result(userService.updateUser(request, id))
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteUser(@PathVariable("id") String id){
        userService.deleteUser(id);
        return ApiResponse.<Void>builder()
                .code(1000)
                .message("Deleted")
                .build();
    }
}
