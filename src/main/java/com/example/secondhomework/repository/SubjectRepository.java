package com.example.secondhomework.repository;

import com.example.secondhomework.model.SubjectEntity;
import com.example.secondhomework.model.groups.SubGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SubjectRepository extends JpaRepository<SubjectEntity, UUID> {

    Optional<SubjectEntity> findByTitle(String string);
}
