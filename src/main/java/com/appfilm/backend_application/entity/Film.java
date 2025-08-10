package com.appfilm.backend_application.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    private String genre;

    @Column(name = "year")
    private int year;

    @Column(name = "language")
    private String language;

    @Column(name = "country")
    private String country;

    @Column(name = "director")
    private String director;

    @Column(name = "actors")
    private String actors;

    @Column(name = "trailer_url")
    private String trailerUrl;

    @Column(name = "available_copies")
    private int availableCopies;

    @Column(name = "image_url")
    private String imageUrl;

    public Film() {}

    // Getters & setters (ou utilise Lombok)
}
