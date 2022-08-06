package io.github.dvitorsantos.repository;

import io.github.dvitorsantos.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findById(Long id);
}
