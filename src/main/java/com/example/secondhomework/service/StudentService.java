package com.example.secondhomework.service;

import com.example.secondhomework.dto.request.StudentRequest;
import com.example.secondhomework.dto.response.StudentResponse;
import com.example.secondhomework.model.users.StudentEntity;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    StudentEntity getById(UUID x);

    List<StudentResponse> getAllStudents();

    void createStudent(StudentRequest request);

    void updateStudent(UUID studentId, StudentRequest request);

    StudentResponse getStudent(UUID studentId);

    void deleteStudent(UUID studentId);
}
