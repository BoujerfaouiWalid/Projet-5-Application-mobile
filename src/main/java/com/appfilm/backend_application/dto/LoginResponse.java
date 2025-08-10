package com.appfilm.backend_application.dto;

public class LoginResponse {
    private final Long id;
    private final String nom;
    private final String email;

    public LoginResponse(Long id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }
}
