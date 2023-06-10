package com.example.secondhomework.repository;

import com.example.secondhomework.model.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {

    Optional<RoomEntity> findByRoomNumber(String string);

}
