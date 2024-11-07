package com.minhnghia.TaskManagement.service;

import com.minhnghia.TaskManagement.dto.request.TaskRequest;
import com.minhnghia.TaskManagement.entity.Task;
import com.minhnghia.TaskManagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public boolean createTask(TaskRequest request){
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setCreateAt(request.getCreateAt());
        task.setDueDate(request.getDueDate());
        taskRepository.save(task);
        return true;
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(String id){
        return taskRepository.findById(id).orElseThrow(()->new RuntimeException("Task not found!"));
    }

    public boolean updateTask(TaskRequest request, String id){
        Task task = getTaskById(id);
        if(task != null){
            task.setTitle(request.getTitle());
            task.setDescription(request.getDescription());
            task.setStatus(request.getStatus());
            task.setCreateAt(request.getCreateAt());
            task.setDueDate(request.getDueDate());
            taskRepository.save(task);
            return true;
        }
        return false;
    }

    public boolean deleteTask(String id){
        Task task = getTaskById(id);
        if(task != null){
            taskRepository.delete(task);
            return true;
        }
        return false;
    }
}
