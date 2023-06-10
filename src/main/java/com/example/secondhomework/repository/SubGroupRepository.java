package com.example.secondhomework.repository;

import com.example.secondhomework.model.groups.SubGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubGroupRepository extends JpaRepository<SubGroupEntity, UUID> {
}
