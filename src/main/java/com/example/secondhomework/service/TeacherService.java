package com.example.secondhomework.service;

import com.example.secondhomework.dto.request.TeacherRequest;
import com.example.secondhomework.dto.response.TeacherResponse;
import com.example.secondhomework.model.users.TeacherEntity;

import java.util.List;
import java.util.UUID;

public interface TeacherService {

    TeacherEntity getByUsername(String teacher_username);

    List<TeacherResponse> getAllTeachers();

    void createTeacher(TeacherRequest request);

    void updateTeacher(UUID teacherId, TeacherRequest request);

    TeacherResponse getTeacher(UUID teacherId);

    void deleteTeacher(UUID teacherId);
}
