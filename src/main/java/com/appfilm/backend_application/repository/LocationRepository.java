package com.appfilm.backend_application.repository;

import com.appfilm.backend_application.entity.Location;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByUserId(Long userId);
    boolean existsByUserIdAndFilmIdAndDateRetourIsNull(Long userId, Long filmId);
}
