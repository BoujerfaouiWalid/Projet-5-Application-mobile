package com.appfilm.backend_application.repository;

import com.appfilm.backend_application.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByTitleContainingIgnoreCase(String title);

    List<Film> findByTitreContainingIgnoreCase(String keyword);
}
