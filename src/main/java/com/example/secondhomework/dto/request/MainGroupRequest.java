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
public class MainGroupRequest {
    private String grade;
    private char type;
    private String teacher_username;
    private List<UUID> students_id;
}
