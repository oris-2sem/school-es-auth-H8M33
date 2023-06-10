package com.example.secondhomework.controller;

import com.example.secondhomework.dto.request.MainGroupRequest;
import com.example.secondhomework.dto.request.SubGroupRequest;
import com.example.secondhomework.dto.response.MainGroupResponse;
import com.example.secondhomework.dto.response.SubGroupResponse;
import com.example.secondhomework.service.SubGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group/sub")
public class SubGroupController {

    private final SubGroupService service;

    @GetMapping()
    public List<SubGroupResponse> getAllGroups(){
        return service.getAllGroups();
    }

    @PostMapping()
    public void createGroup(@RequestBody SubGroupRequest request){
        service.createGroup(request);
    }

    @PutMapping("/{groupId}")
    public void updateGroup(@PathVariable UUID groupId, @RequestBody SubGroupRequest request){
        service.updateGroup(groupId,request);
    }

    @GetMapping("/{groupId}")
    public SubGroupResponse getGroup(@PathVariable UUID groupId){
        return service.getGroup(groupId);
    }

    @DeleteMapping("/{groupId}")
    public void deleteGroup(@PathVariable UUID groupId){
        service.deleteGroup(groupId);
    }
}
