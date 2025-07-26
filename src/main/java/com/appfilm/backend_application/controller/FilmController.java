package com.appfilm.backend_application.controller;

import com.appfilm.backend_application.entity.Film;
import com.appfilm.backend_application.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/films")
@CrossOrigin(origins = "*") // pour l'accès Android
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping
    public List<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/{id}")
    public Film getFilm(@PathVariable Long id) {
        return filmService.getFilmById(id);
    }

    @GetMapping("/search")
    public List<Film> searchFilms(@RequestParam String q) {
        return filmService.search(q);
    }
}
