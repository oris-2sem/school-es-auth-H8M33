package com.example.secondhomework.security.service;

import com.example.secondhomework.model.users.AbstractUserEntity;
import com.example.secondhomework.model.users.ParentEntity;
import com.example.secondhomework.model.users.StudentEntity;
import com.example.secondhomework.model.users.TeacherEntity;
import com.example.secondhomework.repository.ParentRepository;
import com.example.secondhomework.repository.StudentRepository;
import com.example.secondhomework.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final TeacherRepository teacherRepository;

    private final StudentRepository studentRepository;

    private final ParentRepository parentRepository;

    @Override
    public AbstractUserEntity getUserEntityByUsername(String username) {
        Optional<TeacherEntity> teacher = teacherRepository.findByUsername(username);
        if (teacher.isPresent()){
            return teacher.get();
        }
        Optional<StudentEntity> student = studentRepository.findByUsername(username);
        if (student.isPresent()){
            return student.get();
        }
        Optional<ParentEntity> parent = parentRepository.findByUsername(username);
        if (parent.isPresent()){
            return parent.get();
        }
        throw new RuntimeException();
    }
}
