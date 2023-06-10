package com.example.secondhomework.security.service;

import com.example.secondhomework.dto.request.AuthRequest;
import com.example.secondhomework.dto.response.AuthResponse;
import com.example.secondhomework.model.users.AbstractUserEntity;
import io.jsonwebtoken.Claims;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BaseAuthService implements AuthService {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    private final PasswordEncoder encoder;

    private final AuthInfoService authInfoService;

    private final HashMap<UUID, String> refreshTokenRepository;

    @Override
    @PreAuthorize("@baseUserService.isActivated(#authRequest.username)")
    @Transactional
    public AuthResponse login(@NonNull AuthRequest authRequest) {
        final AbstractUserEntity user = userService.getUserEntityByUsername(authRequest.getUsername());
        if (encoder.matches(authRequest.getPassword(), user.getHashPassword())) {
            final String accessToken = jwtProvider.generateAccessToken(user);
            final String refreshToken = jwtProvider.generateRefreshToken(user);
            refreshTokenRepository.put(user.getId(), refreshToken);
            return new AuthResponse(accessToken, refreshToken);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public AuthResponse getAccessToken(@NonNull String refreshToken) {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final UUID userId = UUID.fromString(claims
                    .get("id", String.class));
            final String saveRefreshToken = refreshTokenRepository.get(userId);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final AbstractUserEntity user = userService.getUserEntityByUsername(login);
                final String accessToken = jwtProvider.generateAccessToken(user);
                return new AuthResponse(accessToken, null);
            }
        }
        return new AuthResponse(null, null);
    }

    @Override
    public AuthResponse refresh(@NonNull String refreshToken) {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final UUID userId = UUID.fromString(claims
                    .get("id", String.class));
            final String saveRefreshToken = refreshTokenRepository.get(userId);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final AbstractUserEntity user = userService.getUserEntityByUsername(login);
                final String accessToken = jwtProvider.generateAccessToken(user);
                final String newRefreshToken = jwtProvider.generateRefreshToken(user);
                refreshTokenRepository.put(user.getId(), newRefreshToken);
                return new AuthResponse(accessToken, newRefreshToken);
            }
        }
        throw new RuntimeException();
    }

    @Override
    @Transactional
    public void logout() {
        refreshTokenRepository.remove(authInfoService.getAuthInfo().getId());
    }

}
