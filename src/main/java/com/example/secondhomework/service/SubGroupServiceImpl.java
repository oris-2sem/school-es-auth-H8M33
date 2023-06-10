package com.example.secondhomework.service;

import com.example.secondhomework.dto.request.SubGroupRequest;
import com.example.secondhomework.dto.response.MainGroupResponse;
import com.example.secondhomework.dto.response.SubGroupResponse;
import com.example.secondhomework.model.groups.MainGroupEntity;
import com.example.secondhomework.model.groups.SubGroupEntity;
import com.example.secondhomework.repository.SubGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubGroupServiceImpl implements SubGroupService {

    private final SubGroupRepository repository;

    private final StudentService studentService;

    @Override
    public SubGroupEntity getById(UUID x) {
        return null;
    }

    @Override
    public List<SubGroupResponse> getAllGroups() {
        return repository.findAll().stream().map(x -> SubGroupResponse.builder()
                .id(x.getId())
                .grade(x.getGrade())
                .build()).toList();
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void createGroup(SubGroupRequest request) {
        repository.save(
                SubGroupEntity.builder()
                        .grade(request.getGrade())
                        .students(request.getStudents_id().stream().map(studentService::getById).collect(Collectors.toSet()))
                        .build()
        );
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void updateGroup(UUID groupId, SubGroupRequest request) {
        repository.save(repository.findById(groupId).map(x -> {
            x.setStudents(request.getStudents_id().stream().map(studentService::getById).collect(Collectors.toSet()));
            return x;
        }).orElseThrow(RuntimeException::new));
    }

    @Override
    public SubGroupResponse getGroup(UUID groupId) {
        return repository.findById(groupId).map(x -> SubGroupResponse.builder()
                .id(x.getId())
                .grade(x.getGrade())
                .build()).orElseThrow(RuntimeException::new);
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void deleteGroup(UUID groupId) {
        repository.deleteById(groupId);
    }
}
