package io.github.dvitorsantos.repository;

import io.github.dvitorsantos.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    Optional<Disciplina> findById(Long id);
}