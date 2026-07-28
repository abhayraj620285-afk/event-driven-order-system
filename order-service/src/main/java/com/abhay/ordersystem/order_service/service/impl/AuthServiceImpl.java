package com.abhay.ordersystem.order_service.service.impl;

import com.abhay.ordersystem.order_service.dto.AuthResponse;
import com.abhay.ordersystem.order_service.dto.LoginRequest;
import com.abhay.ordersystem.order_service.dto.RegisterRequest;
import com.abhay.ordersystem.order_service.repository.UserRepository;
import com.abhay.ordersystem.order_service.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public String register(RegisterRequest request) {
        return "";
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
