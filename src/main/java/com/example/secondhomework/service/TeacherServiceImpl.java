package com.example.secondhomework.service;

import com.example.secondhomework.dto.request.TeacherRequest;
import com.example.secondhomework.dto.response.StudentResponse;
import com.example.secondhomework.dto.response.TeacherResponse;
import com.example.secondhomework.model.users.StudentEntity;
import com.example.secondhomework.model.users.TeacherEntity;
import com.example.secondhomework.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements com.example.secondhomework.service.TeacherService {

    private final TeacherRepository repository;

    private final PasswordEncoder encoder;

    @Override
    public TeacherEntity getByUsername(String teacher_username) {
        return repository.findByUsername(teacher_username).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<TeacherResponse> getAllTeachers() {
        return repository.findAll().stream().map(x -> TeacherResponse.builder()
                .id(x.getId())
                .firstName(x.getFirstName())
                .secondName(x.getSecondName())
                .patronymic(x.getPatronymic())
                .username(x.getUsername())
                .build()).toList();
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void createTeacher(TeacherRequest request) {
        repository.save(TeacherEntity.builder()
                .firstName(request.getFirstName())
                .secondName(request.getSecondName())
                .patronymic(request.getPatronymic())
                .role("TEACHER")
                .hashPassword(encoder.encode(request.getHashPassword()))
                .username(request.getUsername())
                .build());
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void updateTeacher(UUID teacherId, TeacherRequest request) {
        repository.save(
                repository.findById(teacherId)
                        .map(x -> {
                                    x.setFirstName(request.getFirstName());
                                    x.setSecondName(request.getSecondName());
                                    x.setPatronymic(request.getPatronymic());
                                    x.setHashPassword(encoder.encode(request.getHashPassword()));
                                    x.setUsername(request.getUsername());
                                    return x;
                                }
                        )
                        .orElseThrow(RuntimeException::new)
        );
    }

    @Override
    public TeacherResponse getTeacher(UUID teacherId) {
        return repository.findById(teacherId).map(x -> TeacherResponse.builder()
                .id(x.getId())
                .firstName(x.getFirstName())
                .secondName(x.getSecondName())
                .patronymic(x.getPatronymic())
                .username(x.getUsername())
                .build()).orElseThrow(RuntimeException::new);
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void deleteTeacher(UUID teacherId) {
        repository.deleteById(teacherId);
    }
}
