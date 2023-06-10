package com.example.secondhomework.service;

import com.example.secondhomework.dto.request.LessonRequest;
import com.example.secondhomework.dto.response.LessonResponse;
import com.example.secondhomework.model.LessonEntity;

import java.util.List;
import java.util.UUID;

public interface LessonService {
    List<LessonResponse> getAllLessons();

    void createLesson(LessonRequest request);

    void updateLesson(UUID lessonId, LessonRequest request);

    LessonResponse getLesson(UUID lessonId);

    void deleteLesson(UUID lessonId);

    LessonEntity getLessonEntity(UUID lesson_id);
}
