package com.appfilm.backend_application.dto;

public class RegisterRequest {
    private final String nom;
    private final String email;
    private final String motDePasse;

    public RegisterRequest(String nom, String email, String motDePasse) {
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }
}
