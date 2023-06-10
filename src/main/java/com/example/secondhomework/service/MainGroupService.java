package com.example.secondhomework.service;

import com.example.secondhomework.dto.request.MainGroupRequest;
import com.example.secondhomework.dto.response.MainGroupResponse;
import com.example.secondhomework.model.groups.MainGroupEntity;

import java.util.List;
import java.util.UUID;

public interface MainGroupService {
    List<MainGroupResponse> getAllGroups();

    void createGroup(MainGroupRequest request);

    void updateGroup(UUID groupId, MainGroupRequest request);

    MainGroupResponse getGroup(UUID groupId);

    void deleteGroup(UUID groupId);

    MainGroupEntity getById(UUID x);
}
