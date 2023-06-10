package com.example.secondhomework.service;

import com.example.secondhomework.dto.request.TaskRequest;
import com.example.secondhomework.dto.response.TaskResponse;
import com.example.secondhomework.model.TaskEntity;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    TaskEntity getById(UUID taskId);

    List<TaskResponse> getAllTasks();

    void createTask(TaskRequest request);

    void updateTask(UUID taskId, TaskRequest request);

    TaskResponse getTask(UUID taskId);

    void deleteTask(UUID taskId);
}
