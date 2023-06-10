package com.example.secondhomework.service;

import com.example.secondhomework.dto.request.SubjectRequest;
import com.example.secondhomework.dto.response.SubjectResponse;
import com.example.secondhomework.model.SubjectEntity;

import java.util.List;
import java.util.UUID;

public interface SubjectService {
    SubjectEntity getByTitle(String subject);

    List<SubjectResponse> getAllSubjects();

    void createSubject(SubjectRequest request);

    void updateSubject(UUID subjectId, SubjectRequest request);

    SubjectResponse getSubject(UUID subjectId);

    void deleteSubject(UUID subjectId);
}
