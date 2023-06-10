package com.example.secondhomework.security.service;


import com.example.secondhomework.dto.request.AuthRequest;
import com.example.secondhomework.dto.response.AuthResponse;
import lombok.NonNull;

public interface AuthService {
    AuthResponse login(@NonNull AuthRequest authRequest);

    AuthResponse getAccessToken(@NonNull String refreshToken);

    AuthResponse refresh(@NonNull String refreshToken);

    void logout();
}
