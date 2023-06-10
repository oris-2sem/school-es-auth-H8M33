package com.example.secondhomework.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonResponse {
    private UUID id;
    private String start_time;
    private String end_time;
    private String subject;
    private String teacher_username;
    private String room_number;
}
