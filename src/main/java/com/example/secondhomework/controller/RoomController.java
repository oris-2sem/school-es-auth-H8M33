package com.example.secondhomework.controller;

import com.example.secondhomework.dto.request.LessonRequest;
import com.example.secondhomework.dto.request.RoomRequest;
import com.example.secondhomework.dto.response.LessonResponse;
import com.example.secondhomework.dto.response.RoomResponse;
import com.example.secondhomework.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService service;

    @GetMapping()
    public List<RoomResponse> getAllRooms(){
        return service.getAllRooms();
    }

    @PostMapping()
    public void createRoom(@RequestBody RoomRequest request){
        service.createRoom(request);
    }

    @PutMapping("/{roomId}")
    public void updateRoom(@PathVariable UUID roomId, @RequestBody RoomRequest request){
        service.updateRoom(roomId,request);
    }

    @GetMapping("/{roomId}")
    public RoomResponse getRoom(@PathVariable UUID roomId){
        return service.getRoom(roomId);
    }

    @DeleteMapping("/{roomId}")
    public void deleteRoom(@PathVariable UUID roomId){
        service.deleteRoom(roomId);
    }
}
