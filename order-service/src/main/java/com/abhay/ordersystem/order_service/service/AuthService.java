package com.abhay.ordersystem.order_service.service;

import com.abhay.ordersystem.order_service.dto.AuthResponse;
import com.abhay.ordersystem.order_service.dto.LoginRequest;
import com.abhay.ordersystem.order_service.dto.RegisterRequest;

public interface AuthService {

    String register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

}