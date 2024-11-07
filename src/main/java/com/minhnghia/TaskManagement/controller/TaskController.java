package com.minhnghia.TaskManagement.controller;

import com.minhnghia.TaskManagement.dto.request.TaskRequest;
import com.minhnghia.TaskManagement.entity.Task;
import com.minhnghia.TaskManagement.repository.TaskRepository;
import com.minhnghia.TaskManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public boolean createTask(@RequestBody TaskRequest request){
        taskService.createTask(request);
        return true;
    }
    @GetMapping
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @GetMapping("{id}")
    public Task getTaskById(@PathVariable("id") String id){
        return taskService.getTaskById(id);
    }

    @PostMapping("{id}")
    public boolean updateTask(@RequestBody TaskRequest request,@PathVariable("id") String id){
        return taskService.updateTask(request, id);
    }

    @DeleteMapping("{id}")
    public boolean deleteTask(@PathVariable("id") String id){
        return taskService.deleteTask(id);
    }
}
