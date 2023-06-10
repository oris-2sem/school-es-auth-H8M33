package com.example.secondhomework.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParentRequest {
    private String username;
    
    private String hashPassword;
    
    private String firstName;
    
    private String secondName;
    
    private String patronymic;
}
