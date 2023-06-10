package com.example.secondhomework.service;

import com.example.secondhomework.dto.request.MainGroupRequest;
import com.example.secondhomework.dto.response.MainGroupResponse;
import com.example.secondhomework.model.groups.MainGroupEntity;
import com.example.secondhomework.repository.MainGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MainGroupServiceImpl implements MainGroupService{

    private final MainGroupRepository repository;

    private final TeacherService teacherService;

    private final StudentService studentService;

    @Override
    public List<MainGroupResponse> getAllGroups() {
        return repository.findAll().stream().map(x -> MainGroupResponse.builder()
                .id(x.getId())
                .type(x.getType()+"")
                .grade(x.getGrade())
                .build()).toList();
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void createGroup(MainGroupRequest request) {
        repository.save(
                MainGroupEntity.builder()
                        .type(request.getType())
                        .classroomTeacher(teacherService.getByUsername(request.getTeacher_username()))
                        .grade(request.getGrade())
                        .students(request.getStudents_id().stream().map(studentService::getById).collect(Collectors.toSet()))
                        .build()
        );
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void updateGroup(UUID groupId, MainGroupRequest request) {
        repository.save(repository.findById(groupId).map(x -> {
            x.setType(request.getType());
            x.setClassroomTeacher(teacherService.getByUsername(request.getTeacher_username()));
            x.setStudents(request.getStudents_id().stream().map(studentService::getById).collect(Collectors.toSet()));
            return x;
        }).orElseThrow(RuntimeException::new));
    }

    @Override
    public MainGroupResponse getGroup(UUID groupId) {
        return repository.findById(groupId).map(x -> MainGroupResponse.builder()
                .id(x.getId())
                .type(x.getType()+"")
                .grade(x.getGrade())
                .build()).orElseThrow(RuntimeException::new);
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void deleteGroup(UUID groupId) {
        repository.deleteById(groupId);
    }

    @Override
    public MainGroupEntity getById(UUID x) {
        return repository.findById(x).orElseThrow(RuntimeException::new);
    }
}
