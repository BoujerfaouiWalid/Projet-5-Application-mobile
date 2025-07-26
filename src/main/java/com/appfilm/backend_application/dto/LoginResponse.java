package com.appfilm.backend_application.dto;

public class LoginResponse {
    public Long id;
    public String nom;
    public String email;

    public LoginResponse(Long id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }
}
