package com.example.secondhomework.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherResponse {
    private UUID id;

    private String username;
    
    private String firstName;
    
    private String secondName;
    
    private String patronymic;
}
