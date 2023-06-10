package com.example.secondhomework.service;

import com.example.secondhomework.dto.request.MarkRequest;
import com.example.secondhomework.dto.response.MarkResponse;

import java.util.List;
import java.util.UUID;

public interface MarkService {
    List<MarkResponse> getAllMarks();

    void createMark(UUID studentId, UUID taskId,MarkRequest request);

    void updateMark(UUID markId, UUID studentId, UUID taskId, MarkRequest request);

    MarkResponse getMark(UUID markId);

    void deleteMark(UUID markId);
}
