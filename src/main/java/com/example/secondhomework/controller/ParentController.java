package com.example.secondhomework.controller;

import com.example.secondhomework.dto.request.ParentRequest;
import com.example.secondhomework.dto.response.ParentResponse;
import com.example.secondhomework.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/parents")
public class ParentController {

    private final ParentService service;

    @GetMapping()
    public List<ParentResponse> getAllParents(){
        return service.getAllParents();
    }

    @PostMapping("/create/{studentId}")
    public void createParent(@PathVariable UUID studentId, @RequestBody ParentRequest request){
        service.createParent(studentId, request);
    }

    @PutMapping("/{parentId}/{studentId}")
    public void updateParent(@PathVariable UUID parentId, @PathVariable UUID studentId, @RequestBody ParentRequest request){
        service.updateParent(parentId, studentId, request);
    }

    @GetMapping("/{parentId}")
    public ParentResponse getParent(@PathVariable UUID parentId){
        return service.getParent(parentId);
    }

    @DeleteMapping("/{parentId}")
    public void deleteParent(@PathVariable UUID parentId){
        service.deleteParent(parentId);
    }

}
