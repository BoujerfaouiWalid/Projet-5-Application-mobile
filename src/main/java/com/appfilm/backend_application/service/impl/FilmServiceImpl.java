package com.appfilm.backend_application.service.impl;

import com.appfilm.backend_application.entity.Film;
import com.appfilm.backend_application.repository.FilmRepository;
import com.appfilm.backend_application.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Film getFilmById(Long id) {
        return filmRepository.findById(id).orElseThrow(() -> new RuntimeException("Film introuvable"));
    }

    @Override
    public List<Film> search(String keyword) {
        return filmRepository.findByTitreContainingIgnoreCase(keyword);
    }
}
