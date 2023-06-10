package com.example.secondhomework.service;

import com.example.secondhomework.dto.request.RoomRequest;
import com.example.secondhomework.dto.response.RoomResponse;
import com.example.secondhomework.model.RoomEntity;
import com.example.secondhomework.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{

    private final RoomRepository repository;

    @Override
    public RoomEntity getByRoomNumber(String room_number) {
        return repository.findByRoomNumber(room_number).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<RoomResponse> getAllRooms() {
        return repository.findAll().stream().map(x -> RoomResponse.builder().id(x.getId()).roomNumber(x.getRoomNumber()).build()).toList();
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void createRoom(RoomRequest request) {
        repository.save(RoomEntity.builder()
                        .roomNumber(request.getRoomNumber())
                .build());
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void updateRoom(UUID roomId, RoomRequest request) {
        repository.findById(roomId).map(x -> {
            x.setRoomNumber(request.getRoomNumber());
            return x;
        }).orElseThrow(RuntimeException::new);
    }

    @Override
    public RoomResponse getRoom(UUID roomId) {
        return repository.findById(roomId).map(x -> RoomResponse.builder().id(x.getId()).roomNumber(x.getRoomNumber()).build())
                .orElseThrow(RuntimeException::new);
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void deleteRoom(UUID roomId) {
        repository.deleteById(roomId);
    }
}
