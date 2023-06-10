package com.example.secondhomework.service;

import com.example.secondhomework.dto.request.ParentRequest;
import com.example.secondhomework.dto.response.ParentResponse;

import java.util.List;
import java.util.UUID;

public interface ParentService {
    List<ParentResponse> getAllParents();

    void createParent(UUID studentId, ParentRequest request);

    void updateParent(UUID parentId, UUID studentId, ParentRequest request);

    ParentResponse getParent(UUID parentId);

    void deleteParent(UUID parentId);
}
