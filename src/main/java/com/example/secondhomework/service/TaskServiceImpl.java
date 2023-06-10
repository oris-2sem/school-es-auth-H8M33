package com.example.secondhomework.service;

import com.example.secondhomework.dto.request.TaskRequest;
import com.example.secondhomework.dto.response.TaskResponse;
import com.example.secondhomework.model.TaskEntity;
import com.example.secondhomework.model.enums.TaskEnum;
import com.example.secondhomework.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository repository;

    private final LessonService lessonService;

    private final StudentService studentService;

    @Override
    public TaskEntity getById(UUID taskId) {
        return null;
    }

    @Override
    public List<TaskResponse> getAllTasks() {
        return repository.findAll().stream().map(x -> TaskResponse.builder()
                .taskType(x.getTaskType().getValue())
                .build()).toList();
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void createTask(TaskRequest request) {
        repository.save(TaskEntity.builder()
                        .lesson(lessonService.getLessonEntity(request.getLesson_id()))
                        .students(request.getStudent_id().stream().map(studentService::getById).collect(Collectors.toSet()))
                        .taskType(TaskEnum.valueOf(request.getTaskType()))
                .build());
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void updateTask(UUID taskId, TaskRequest request) {
        repository.save(
                repository.findById(taskId).map(x -> {
                    x.setTaskType(TaskEnum.valueOf(request.getTaskType()));
                    x.setLesson(lessonService.getLessonEntity(request.getLesson_id()));
                    x.setStudents(request.getStudent_id().stream().map(studentService::getById).collect(Collectors.toSet()));
                    return x;
                }).orElseThrow(RuntimeException::new)
        );
    }

    @Override
    public TaskResponse getTask(UUID taskId) {
        return repository.findById(taskId).map(x ->TaskResponse.builder()
                .id(x.getId())
                .taskType(x.getTaskType().getValue())
                .build()).orElseThrow(RuntimeException::new);
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void deleteTask(UUID taskId) {
        repository.deleteById(taskId);
    }
}
