package io.github.dvitorsantos.repository;

import io.github.dvitorsantos.entity.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeriodoRepository extends JpaRepository<Periodo, Long> {
    Optional<Periodo> findById(Long id);

}
