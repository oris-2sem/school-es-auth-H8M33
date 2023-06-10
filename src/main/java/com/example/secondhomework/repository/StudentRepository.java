package com.example.secondhomework.repository;

import com.example.secondhomework.model.users.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {

    Optional<StudentEntity> findByUsername(String username);
}
