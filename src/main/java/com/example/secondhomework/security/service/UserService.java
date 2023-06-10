package com.example.secondhomework.security.service;

import com.example.secondhomework.model.users.AbstractUserEntity;

public interface UserService {
    AbstractUserEntity getUserEntityByUsername(String username);
}
