package com.example.secondhomework.security.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Getter
@RequiredArgsConstructor
public enum UserRole implements GrantedAuthority {
    STUDENT("STUDENT"),
    PARENT("PARENT"),
    TEACHER("TEACHER");

    private final String value;

    @Override
    public String getAuthority() {
        return value;
    }
}
