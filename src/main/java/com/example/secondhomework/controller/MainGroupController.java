package com.example.secondhomework.controller;

import com.example.secondhomework.dto.request.MainGroupRequest;
import com.example.secondhomework.dto.response.MainGroupResponse;
import com.example.secondhomework.service.MainGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group/main")
public class MainGroupController {

    private final MainGroupService service;

    @GetMapping()
    public List<MainGroupResponse> getAllGroups(){
        return service.getAllGroups();
    }

    @PostMapping()
    public void createGroup(@RequestBody MainGroupRequest request){
        service.createGroup(request);
    }

    @PutMapping("/{groupId}")
    public void updateGroup(@PathVariable UUID groupId, @RequestBody MainGroupRequest request){
        service.updateGroup(groupId,request);
    }

    @GetMapping("/{groupId}")
    public MainGroupResponse getGroup(@PathVariable UUID groupId){
        return service.getGroup(groupId);
    }

    @DeleteMapping("/{groupId}")
    public void deleteGroup(@PathVariable UUID groupId){
        service.deleteGroup(groupId);
    }
}
