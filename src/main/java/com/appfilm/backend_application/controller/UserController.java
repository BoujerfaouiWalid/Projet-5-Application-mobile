package com.appfilm.backend_application.controller;

import com.appfilm.backend_application.dto.LoginRequest;
import com.appfilm.backend_application.dto.LoginResponse;
import com.appfilm.backend_application.dto.RegisterRequest;
import com.appfilm.backend_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        userService.register(request);
        return "Inscription réussie";
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}
