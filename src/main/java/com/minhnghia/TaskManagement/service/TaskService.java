package com.minhnghia.TaskManagement.service;

import com.minhnghia.TaskManagement.dto.request.TaskCreationRequest;
import com.minhnghia.TaskManagement.dto.request.TaskUpdateRequest;
import com.minhnghia.TaskManagement.dto.response.TaskResponse;
import com.minhnghia.TaskManagement.entity.Task;
import com.minhnghia.TaskManagement.mapper.TaskMapper;
import com.minhnghia.TaskManagement.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    public TaskResponse createTask(TaskCreationRequest request){
        Task task = taskMapper.toTask(request);
        taskRepository.save(task);
        return taskMapper.toTaskResponse(task);
    }

    public List<Task> getTasks(){
        return taskRepository.findAll().stream().toList();
    }

    public Task selectTaskById(String id){
        return taskRepository.findById(id).orElseThrow(()->new RuntimeException("Task not found!"));
    }
    public TaskResponse getTaskById(String id){
        Task task = selectTaskById(id);
        return taskMapper.toTaskResponse(task);
    }

    public TaskResponse updateTask(TaskUpdateRequest request, String id){
        Task task = selectTaskById(id);
        taskMapper.updateTask(task, request);
        taskRepository.save(task);
        return taskMapper.toTaskResponse(task);
    }

    public TaskResponse updateStatus(String id, String status){
        Task task = selectTaskById(id);
        task.setStatus(status);
        taskRepository.save(task);
        return taskMapper.toTaskResponse(task);
    }

    public void deleteTask(String id){
        Task task = selectTaskById(id);
        taskRepository.delete(task);
    }

    @Transactional
    public List<Task> findTaskByStatus(String status){
        return taskRepository.findTasksByStatus(status);
    }
    public List<Task> findTaskByTitle(String title){
        return taskRepository.findByTitle(title);
    }
}
