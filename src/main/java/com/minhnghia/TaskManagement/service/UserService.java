package com.minhnghia.TaskManagement.service;

import com.minhnghia.TaskManagement.dto.request.UserCreationRequest;
import com.minhnghia.TaskManagement.dto.request.UserUpdateRequest;
import com.minhnghia.TaskManagement.dto.response.UserResponse;
import com.minhnghia.TaskManagement.entity.User;
import com.minhnghia.TaskManagement.mapper.UserMapper;
import com.minhnghia.TaskManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public UserResponse createUser(UserCreationRequest request){
        User user = userMapper.toUser(request);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    public List<UserResponse> getAllUsers(){
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    public UserResponse getUserById(String id){
        return userMapper.toUserResponse(
                userRepository.findById(id)
                        .orElseThrow(()-> new RuntimeException("User not found!")));
    }
    public User getUser(String id){
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found!"));
    }
    public UserResponse updateUser(UserUpdateRequest request, String id){
        User user = getUser(id);
        userMapper.updateUser(user, request);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    public void deleteUser(String id){
        userRepository.delete(getUser(id));
    }
}
