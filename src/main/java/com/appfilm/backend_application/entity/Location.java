package com.appfilm.backend_application.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Film film;

    private LocalDate dateLocation;
    private LocalDate dateRetour;

    public Location() {}

    // Getters et Setters
}
