package com.example.secondhomework.controller;

import com.example.secondhomework.dto.request.LessonRequest;
import com.example.secondhomework.dto.response.LessonResponse;
import com.example.secondhomework.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService service;

    @GetMapping()
    public List<LessonResponse> getAllLessons(){
        return service.getAllLessons();
    }

    @PostMapping()
    public void createLesson(@RequestBody LessonRequest request){
        service.createLesson(request);
    }

    @PutMapping("/{lessonId}")
    public void updateLesson(@PathVariable UUID lessonId, @RequestBody LessonRequest request){
        service.updateLesson(lessonId,request);
    }

    @GetMapping("/{lessonId}")
    public LessonResponse getLesson(@PathVariable UUID lessonId){
        return service.getLesson(lessonId);
    }

    @DeleteMapping("/{lessonId}")
    public void deleteLesson(@PathVariable UUID lessonId){
        service.deleteLesson(lessonId);
    }

}
