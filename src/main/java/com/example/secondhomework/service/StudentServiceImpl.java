package com.example.secondhomework.service;

import com.example.secondhomework.dto.request.StudentRequest;
import com.example.secondhomework.dto.response.StudentResponse;
import com.example.secondhomework.model.users.StudentEntity;
import com.example.secondhomework.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    private final PasswordEncoder encoder;

    @Override
    public StudentEntity getById(UUID x) {
        return repository.findById(x).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return repository.findAll().stream().map(x -> StudentResponse.builder()
                .id(x.getId())
                .firstName(x.getFirstName())
                .secondName(x.getSecondName())
                .patronymic(x.getPatronymic())
                .username(x.getUsername())
                .build()).toList();
    }

    @Override
    public void createStudent(StudentRequest request) {
        repository.save(StudentEntity.builder()
                .firstName(request.getFirstName())
                .secondName(request.getSecondName())
                .patronymic(request.getPatronymic())
                .role("STUDENT")
                .hashPassword(encoder.encode(request.getHashPassword()))
                .username(request.getUsername())
                .build());
    }

    @Override
    @PreAuthorize("hasAuthority('STUDENR') or hasAuthority('PARENT')")
    public void updateStudent(UUID studentId, StudentRequest request) {
        repository.save(
                repository.findById(studentId)
                        .map( x ->{
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
    public StudentResponse getStudent(UUID studentId) {
        return repository.findById(studentId).map(x -> StudentResponse.builder()
                .id(x.getId())
                .firstName(x.getFirstName())
                .secondName(x.getSecondName())
                .patronymic(x.getPatronymic())
                .username(x.getUsername())
                .build()).orElseThrow(RuntimeException::new);
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void deleteStudent(UUID studentId) {
        repository.deleteById(studentId);
    }
}
