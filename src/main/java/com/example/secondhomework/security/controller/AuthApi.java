package com.example.secondhomework.security.controller;

import com.example.secondhomework.dto.request.AuthRequest;
import com.example.secondhomework.dto.request.RefreshJwtRequest;
import com.example.secondhomework.dto.response.AuthResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthApi {

    @PostMapping("/login")
    AuthResponse login(@RequestBody AuthRequest authRequest);

    @PostMapping("/token")
    AuthResponse getNewAccessToken(@RequestBody RefreshJwtRequest request);

    @PostMapping("/refresh")
    AuthResponse getNewRefreshToken(@RequestBody RefreshJwtRequest request);

    @PostMapping("/logout")
    void logout();
}
