package com.example.secondhomework.controller;

import com.example.secondhomework.dto.request.LessonRequest;
import com.example.secondhomework.dto.request.TaskRequest;
import com.example.secondhomework.dto.response.LessonResponse;
import com.example.secondhomework.dto.response.TaskResponse;
import com.example.secondhomework.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    @GetMapping()
    public List<TaskResponse> getAllTasks(){
        return service.getAllTasks();
    }

    @PostMapping()
    public void createTask(@RequestBody TaskRequest request){
        service.createTask(request);
    }

    @PutMapping("/{taskId}")
    public void updateTask(@PathVariable UUID taskId, @RequestBody TaskRequest request){
        service.updateTask(taskId,request);
    }

    @GetMapping("/{taskId}")
    public TaskResponse getTask(@PathVariable UUID taskId){
        return service.getTask(taskId);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable UUID taskId){
        service.deleteTask(taskId);
    }
}
