package io.github.dvitorsantos.repository;

import io.github.dvitorsantos.entity.Diario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiarioRepository extends JpaRepository<Diario, Long> {
    Optional<Diario> findById(Long id);
}
