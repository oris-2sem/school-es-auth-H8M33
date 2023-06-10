package com.example.secondhomework.controller;

import com.example.secondhomework.dto.request.StudentRequest;
import com.example.secondhomework.dto.request.TeacherRequest;
import com.example.secondhomework.dto.response.StudentResponse;
import com.example.secondhomework.dto.response.TeacherResponse;
import com.example.secondhomework.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/teachers")
public class TeacherController {

    private final TeacherService service;

    @GetMapping()
    public List<TeacherResponse> getAllTeachers(){
        return service.getAllTeachers();
    }

    @PostMapping("/create")
    public void createTeacher(@RequestBody TeacherRequest request){
        service.createTeacher( request);
    }

    @PutMapping("/{teacherId}")
    public void updateTeacher( @PathVariable UUID teacherId, @RequestBody TeacherRequest request){
        service.updateTeacher( teacherId, request);
    }

    @GetMapping("/{teacherId}")
    public TeacherResponse getTeacher(@PathVariable UUID teacherId){
        return service.getTeacher(teacherId);
    }

    @DeleteMapping("/{teacherId}")
    public void deleteTeacher(@PathVariable UUID teacherId){
        service.deleteTeacher(teacherId);
    }
}
