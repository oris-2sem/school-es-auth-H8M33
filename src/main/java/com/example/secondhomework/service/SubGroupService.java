package com.example.secondhomework.service;

import com.example.secondhomework.dto.request.SubGroupRequest;
import com.example.secondhomework.dto.response.SubGroupResponse;
import com.example.secondhomework.model.groups.SubGroupEntity;

import java.util.List;
import java.util.UUID;

public interface SubGroupService {
    SubGroupEntity getById(UUID x);

    List<SubGroupResponse> getAllGroups();

    void createGroup(SubGroupRequest request);

    void updateGroup(UUID groupId, SubGroupRequest request);

    SubGroupResponse getGroup(UUID groupId);

    void deleteGroup(UUID groupId);
}
