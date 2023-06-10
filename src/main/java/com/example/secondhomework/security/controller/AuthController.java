package com.example.secondhomework.security.controller;


import com.example.secondhomework.dto.request.AuthRequest;
import com.example.secondhomework.dto.request.RefreshJwtRequest;
import com.example.secondhomework.dto.response.AuthResponse;
import com.example.secondhomework.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController implements AuthApi {

    private final AuthService authService;

    @Override
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }

    @Override
    public AuthResponse getNewAccessToken(@RequestBody RefreshJwtRequest request) {
        return authService.getAccessToken(request.getRefreshToken());
    }

    @Override
    public AuthResponse getNewRefreshToken(@RequestBody RefreshJwtRequest request) {
        return authService.refresh(request.getRefreshToken());
    }

    @Override
    public void logout() {
        authService.logout();
    }

}
