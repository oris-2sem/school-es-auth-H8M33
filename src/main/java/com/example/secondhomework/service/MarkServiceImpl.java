package com.example.secondhomework.service;

import com.example.secondhomework.dto.request.MarkRequest;
import com.example.secondhomework.dto.response.MarkResponse;
import com.example.secondhomework.model.MarkEntity;
import com.example.secondhomework.model.enums.MarkEnum;
import com.example.secondhomework.repository.MarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MarkServiceImpl implements MarkService {

    private final MarkRepository repository;

    private final TaskService taskService;

    private final StudentService studentService;

    @Override
    public List<MarkResponse> getAllMarks() {
        return repository.findAll().stream().map(x -> MarkResponse.builder()
                .id(x.getId())
                .mark(x.getMark().getValue() + "")
                .build()).toList();
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void createMark(UUID studentId, UUID taskId, MarkRequest request) {
        repository.save(MarkEntity.builder()
                .mark(MarkEnum.valueOf(request.getMark() + ""))
                .task(taskService.getById(taskId))
                .student(studentService.getById(studentId))
                .build());
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void updateMark(UUID markId, UUID studentId, UUID taskId, MarkRequest request) {
        repository.save(repository.findById(markId)
                .map(x -> {
                    x.setMark(MarkEnum.valueOf(request.getMark() + ""));
                    x.setTask(taskService.getById(taskId));
                    x.setStudent(studentService.getById(studentId));
                    return x;
                })
                .orElseThrow(RuntimeException::new));
    }


    @Override
    public MarkResponse getMark(UUID markId) {
        return repository.findById(markId).map(x -> MarkResponse.builder()
                .id(x.getId())
                .mark(x.getMark().getValue() + "")
                .build()
        ).orElseThrow(RuntimeException::new);
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void deleteMark(UUID markId) {
        repository.deleteById(markId);
    }
}
