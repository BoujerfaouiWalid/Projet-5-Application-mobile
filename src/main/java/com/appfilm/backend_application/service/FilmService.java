package com.appfilm.backend_application.service;

import com.appfilm.backend_application.entity.Film;
import java.util.List;

public interface FilmService {
    List<Film> getAllFilms();
    Film getFilmById(Long id);
    List<Film> search(String keyword);
}
