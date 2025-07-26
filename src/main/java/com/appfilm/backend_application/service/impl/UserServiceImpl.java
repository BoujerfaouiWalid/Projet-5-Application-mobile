package com.appfilm.backend_application.service.impl;

import com.appfilm.backend_application.dto.LoginRequest;
import com.appfilm.backend_application.dto.LoginResponse;
import com.appfilm.backend_application.dto.RegisterRequest;
import com.appfilm.backend_application.entity.User;
import com.appfilm.backend_application.repository.UserRepository;
import com.appfilm.backend_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(RegisterRequest request) {
        if (userRepository.findByEmail(request.email).isPresent()) {
            throw new RuntimeException("Email déjà utilisé");
        }

        User user = new User();
        user.setNom(request.nom);
        user.setEmail(request.email);
        user.setMotDePasse(passwordEncoder.encode(request.motDePasse));

        userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Optional<User> userOpt = userRepository.findByEmail(request.email);
        if (userOpt.isEmpty()) {
            throw new RuntimeException("Email incorrect");
        }

        User user = userOpt.get();
        if (!passwordEncoder.matches(request.motDePasse, user.getMotDePasse())) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        return new LoginResponse(user.getId(), user.getNom(), user.getEmail());
    }
}
