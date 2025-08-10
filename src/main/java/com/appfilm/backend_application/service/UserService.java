package com.appfilm.backend_application.service;

import com.appfilm.backend_application.dto.LoginRequest;
import com.appfilm.backend_application.dto.LoginResponse;
import com.appfilm.backend_application.dto.RegisterRequest;

public interface UserService {
    void register(RegisterRequest request);
    LoginResponse login(LoginRequest request);
}
