package com.example.secondhomework.service;

import com.example.secondhomework.dto.request.RoomRequest;
import com.example.secondhomework.dto.response.RoomResponse;
import com.example.secondhomework.model.RoomEntity;

import java.util.List;
import java.util.UUID;

public interface RoomService {
    RoomEntity getByRoomNumber(String room_number);

    List<RoomResponse> getAllRooms();

    void createRoom(RoomRequest request);

    void updateRoom(UUID roomId, RoomRequest request);

    RoomResponse getRoom(UUID roomId);

    void deleteRoom(UUID roomId);
}
