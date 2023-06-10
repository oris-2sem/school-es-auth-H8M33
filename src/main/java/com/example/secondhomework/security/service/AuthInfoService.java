package com.example.secondhomework.security.service;

import com.example.secondhomework.security.model.UserAccount;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthInfoService {

    public UserAccount getAuthInfo() {
        return (UserAccount) SecurityContextHolder.getContext().getAuthentication();
    }

}
