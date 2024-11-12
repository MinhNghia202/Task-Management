package com.minhnghia.TaskManagement.controller;

import com.minhnghia.TaskManagement.dto.request.TaskCreationRequest;
import com.minhnghia.TaskManagement.dto.request.TaskUpdateRequest;
import com.minhnghia.TaskManagement.dto.response.ApiResponse;
import com.minhnghia.TaskManagement.dto.response.TaskResponse;
import com.minhnghia.TaskManagement.entity.Task;
import com.minhnghia.TaskManagement.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ApiResponse<TaskResponse> createTask(@RequestBody @Valid TaskCreationRequest request){
        return ApiResponse.<TaskResponse>builder()
                .code(1000)
                .message("Create task is successfully!")
                .result(taskService.createTask(request))
                .build();
    }
    @GetMapping
    public ApiResponse<List<Task>> getTasks(){
        ApiResponse<List<Task>> listApiResponse = new ApiResponse<>();
        listApiResponse.setCode(1000);
        listApiResponse.setMessage("List task: ");
        listApiResponse.setResult(taskService.getTasks());
        return listApiResponse;
    }

    @GetMapping("/{id}")
    public ApiResponse<TaskResponse> getTaskById(@PathVariable("id") String id){
        return ApiResponse.<TaskResponse>builder()
                .code(1000)
                .message("Task by Id")
                .result(taskService.getTaskById(id))
                .build();
    }

    @PostMapping("/{id}")
    public ApiResponse<TaskResponse> updateTask(@RequestBody @Valid TaskUpdateRequest request, @PathVariable("id") String id){
        return ApiResponse.<TaskResponse>builder()
                .code(1000)
                .message("Update is successfully!")
                .result(taskService.updateTask(request, id))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<TaskResponse> updateStatus(@PathVariable("id") String id, @RequestBody String status){
        taskService.updateStatus(id,status);
        return ApiResponse.<TaskResponse>builder()
                .code(1000)
                .message("Update status is successfully!")
                .result(taskService.updateStatus(id, status))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteTask(@PathVariable("id") String id){
        taskService.deleteTask(id);
        return ApiResponse.<Void>builder()
                .code(1000)
                .message("Deleted!")
                .build();
    }
    @GetMapping("/status/{status}")
    public ApiResponse<List<Task>> findTaskByStatus(@PathVariable("status") String status){
        ApiResponse<List<Task>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("Find task by status is successfully!");
        apiResponse.setResult(taskService.findTaskByStatus(status));
        return apiResponse;
    }
    @GetMapping("/title/{title}")
    public ApiResponse<List<Task>> findTaskByTitle(@PathVariable("title") String title){
        ApiResponse<List<Task>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("Find task by title is successfully!");
        apiResponse.setResult(taskService.findTaskByTitle(title));
        return apiResponse;
    }
}
