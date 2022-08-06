package io.github.dvitorsantos.repository;

import io.github.dvitorsantos.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    Optional<Turma> findById(Long id);
}
