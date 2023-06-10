package com.example.secondhomework.repository;

import com.example.secondhomework.model.groups.MainGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MainGroupRepository extends JpaRepository<MainGroupEntity, UUID> {
}
