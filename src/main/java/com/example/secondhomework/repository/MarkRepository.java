package com.example.secondhomework.repository;

import com.example.secondhomework.model.MarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MarkRepository extends JpaRepository<MarkEntity, UUID> {
}
