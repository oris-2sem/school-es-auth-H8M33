package com.example.secondhomework.controller;

import com.example.secondhomework.dto.request.LessonRequest;
import com.example.secondhomework.dto.request.SubjectRequest;
import com.example.secondhomework.dto.response.LessonResponse;
import com.example.secondhomework.dto.response.SubjectResponse;
import com.example.secondhomework.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService service;

    @GetMapping()
    public List<SubjectResponse> getAllSubjects(){
        return service.getAllSubjects();
    }

    @PostMapping()
    public void createSubject(@RequestBody SubjectRequest request){
        service.createSubject(request);
    }

    @PutMapping("/{subjectId}")
    public void updateSubject(@PathVariable UUID subjectId, @RequestBody SubjectRequest request){
        service.updateSubject(subjectId,request);
    }

    @GetMapping("/{subjectId}")
    public SubjectResponse getSubject(@PathVariable UUID subjectId){
        return service.getSubject(subjectId);
    }

    @DeleteMapping("/{subjectId}")
    public void deleteSubject(@PathVariable UUID subjectId){
        service.deleteSubject(subjectId);
    }

}
