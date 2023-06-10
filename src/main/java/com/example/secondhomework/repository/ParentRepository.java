package com.example.secondhomework.repository;

import com.example.secondhomework.model.users.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ParentRepository extends JpaRepository<ParentEntity, UUID> {

    Optional<ParentEntity> findByUsername(String username);
}
