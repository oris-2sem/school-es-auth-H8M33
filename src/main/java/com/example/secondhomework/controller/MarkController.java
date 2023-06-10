package com.example.secondhomework.controller;

import com.example.secondhomework.dto.request.MarkRequest;
import com.example.secondhomework.dto.response.MarkResponse;
import com.example.secondhomework.service.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MarkController {

    private final MarkService service;

    @GetMapping()
    public List<MarkResponse> getAllMarks(){
        return service.getAllMarks();
    }

    @PostMapping("/{studentId}/{taskId}")
    public void createMark(@PathVariable UUID studentId, @PathVariable UUID taskId,@RequestBody MarkRequest request){
        service.createMark(studentId, taskId, request);
    }

    @PutMapping("/{markId}/{studentId}/{taskId}")
    public void updateMark(@PathVariable UUID markId, @PathVariable UUID studentId, @PathVariable UUID taskId, @RequestBody MarkRequest request){
        service.updateMark(markId, studentId, taskId, request);
    }

    @GetMapping("/{markId}")
    public MarkResponse getMark(@PathVariable UUID markId){
        return service.getMark(markId);
    }

    @DeleteMapping("/{markId}")
    public void deleteMark(@PathVariable UUID markId){
        service.deleteMark(markId);
    }
}
