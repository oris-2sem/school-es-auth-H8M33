package com.example.secondhomework.dto.request;

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
public class LessonRequest {
    private DataTimeRequest start_time;
    private DataTimeRequest end_time;
    private String subject;
    private String teacher_username;
    private String room_number;
    private List<UUID> mainGroupId;
    private List<UUID> subGroupId;
}
